package com.example.ledgerone.security.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserPrincipal(
    val userId: Long,
    val username: String,
    private val password: String,
    private val authorities: Collection<GrantedAuthority>
): UserDetails {

    override fun getUsername(): String = username

    override fun getPassword(): String = password

    override fun getAuthorities(): Collection<GrantedAuthority> = authorities

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}