package com.example.ledgerone.security.auth

import com.example.ledgerone.repositories.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User with $username not found")

        return UserPrincipal(
            userId = user.id,
            username = user.username,
            password = user.passwordHash,
            authorities = listOf(SimpleGrantedAuthority("ROLE_USER"))
        )
    }
}