package com.facturator.bill.crud.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturator.bill.crud.security.controller.DTO.JwtResponse;
import com.facturator.bill.crud.security.controller.DTO.LoginRequest;
import com.facturator.bill.crud.security.jwt.JwtProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider tokenProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JwtResponse(jwt, tokenHeader));
	}

}