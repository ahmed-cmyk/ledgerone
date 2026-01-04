package com.example.ledgerone.security.filters

import com.example.ledgerone.repositories.TenantUserRepository
import com.example.ledgerone.security.auth.UserPrincipal
import com.example.ledgerone.tenant.TenantContext
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class TenantContextFilter(
    private val tenantUserRepository: TenantUserRepository,
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val tenantId = request.getHeader("X-Tenant-Id").toLongOrNull()
            if (tenantId == null) {
                response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Missing or invalid tenant id"
                )
                return
            }

            val userId = getAuthenticatedUserId()
                ?: run {
                    response.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        "Unauthenticated"
                    )
                    return
                }

            val allowed = tenantUserRepository
                .existsByTenantIdAndUserId(tenantId, userId)

            if (!allowed) {
                response.sendError(
                    HttpServletResponse.SC_FORBIDDEN,
                    "User has no access to tenant"
                )
            }

            TenantContext.setTenantId(tenantId)

            filterChain.doFilter(request, response)
        } finally {
            TenantContext.clear()
        }
    }

    private fun getAuthenticatedUserId(): Long? {
        val auth = SecurityContextHolder.getContext().authentication
        if (auth == null || !auth.isAuthenticated) return null

        val principal = auth.principal as? UserPrincipal
        return principal?.userId
    }
}