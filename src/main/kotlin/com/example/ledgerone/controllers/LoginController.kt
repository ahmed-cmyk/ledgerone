package com.example.ledgerone.controllers

import com.example.ledgerone.security.auth.UserPrincipal
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController(
    private val authenticationManager: AuthenticationManager,
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<Void> {
        val authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
            loginRequest.username
            , loginRequest.password
        )
        val authenticationResponse = authenticationManager.authenticate(authenticationRequest)
        val principal = authenticationResponse.principal as UserPrincipal
        return ResponseEntity.ok().build<Void>()
    }

    data class LoginRequest(val username: String, val password: String)
}

