package com.example.ledgerone.controllers

import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<Void> {
        val authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
            loginRequest.username,
            loginRequest.password
        )

        val authentication = authenticationManager.authenticate(authenticationRequest)

        SecurityContextHolder.getContext().authentication = authentication

        return ResponseEntity.ok().build()
    }

    data class LoginRequest(val username: String, val password: String)
}

