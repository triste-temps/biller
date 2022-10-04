package com.facturator.bill.crud.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	// Mapper pour "/hello"
	
	@GetMapping("/test")
	public String Salut (Model mod) {
		
		// Ajout au model de l'attribut "date"
		mod.addAttribute("date", new java.util.Date());
		
		// Nom de la vue
		// Avec spring-boot il recherche automatiquement dans 
		// le dossier /src/main/ressources/templates/test.html
		return "test";
	}
	
}
