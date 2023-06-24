package com.cibertec.dawiCL3grupo6.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.dawiCL3grupo6.model.bd.Usuario;

@RequestMapping("/auth")
@Controller
public class UsuarioController {

	@GetMapping("/login")
public String frmlogin() {
	
	return "auth/frmLogin";
}
	
	@GetMapping("/registrarusuario")
	public String frmguardar() {
		
		return"auth/frmRegistro";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarusuario(@ModelAttribute Usuario usuario, Model model) {
		
		
		return"auth/frmRegistro";
	}
}