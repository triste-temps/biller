package com.facturator.bill.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facturator.bill.crud.repository.CompanyRepository;
import com.facturator.bill.crud.security.controller.DTO.LoginRequest;
import com.facturator.bill.crud.security.jwt.JwtProvider;
import com.facturator.bill.crud.security.models.Company;
import com.facturator.bill.crud.security.utils.UserMapper;

@RestController
public class AuthController {

	UserMapper userMapper;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	JwtProvider tokenProvider;

	@Autowired
	AuthenticationManager authenticationManager;

//	@Value("${app.jwtTokenHeader}")
//	private String tokenHeader;
//
//	@Autowired
//	AuthenticationManager authenticationManager;
//
//	@Autowired
//	JwtProvider tokenProvider;

//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {
//		System.err.println("HELLO");
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		String jwt = tokenProvider.generateToken(authentication);
//		System.err.println(jwt);
//
//		return ResponseEntity.ok(new JwtResponse(jwt, tokenHeader));
//	}

	@PostMapping("/signin")
	public String signin(@RequestBody LoginRequest loginRequest) {
		System.err.println("HELLO " + loginRequest.getUsername());
		System.err.println("HELLO " + loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		System.err.println("HELLO " + loginRequest.getUsername());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.err.println(authentication.getPrincipal());

		// générer le token
		String token = tokenProvider.generateToken(authentication);
		// vérifier sa validité
		tokenProvider.validateToken(token);
		return token;
	}
//	@PostMapping("/signin")
//	public String signin(@RequestBody LoginRequest loginRequest) {
//		// généré un nouvel objet de type UserPrincipal
//		UserPrincipal userPrincipal = new UserPrincipal();
//		// on a cherché dans la BDD une entreprise par son mail
//		Optional<Company> laCompany = companyRepository.findByEmail(loginRequest.getUsername());
//		System.err.println(loginRequest.getUsername());
//		// une fois trouvée on la range dans un objet entreprise
//		Company company = laCompany.orElseThrow();
//		// on mappe cet objet entreprise dans son contenant en forme de UserPrincipal
//		userPrincipal = UserMapper.userToPrincipal(company);
//		// on utilise le username de ce UserPrincipal pour générer un JWT
//		return jwt.generateToken(userPrincipal.getUsername());
//	}

	@GetMapping("/test")
	public List<Company> allCompany() {
		System.err.println("Entering function");
		return companyRepository.findAll();
	}

	@GetMapping("/byEmail")
	public String getByEmail() {

		Optional<Company> company = companyRepository.findByEmail("francois@gmail.com");
		Company companie = company.orElseThrow();
		return companie.getEmail();
	}
}