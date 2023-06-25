package com.cibertec.dawiCL3grupo6.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cibertec.dawiCL3grupo6.Services.UsuarioServices;
import com.cibertec.dawiCL3grupo6.model.bd.Usuario;


@RequestMapping("/auth")
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;

	@GetMapping("/login")
	public String frmlogin() {

		return "auth/frmLogin";
	}

	@GetMapping("/registrarusuario")
	public String frmguardar() {

		return "auth/frmRegistro";
	}

	@PostMapping("/guardarUsuario")
	public String guardarusuario(@ModelAttribute Usuario usuario, Model model) {
		usuarioServices.guardarUsuario(usuario);
		model.addAttribute("registroCorrecto", true);

		return "auth/frmRegistro";
	}
	
	@GetMapping("/listar")
    @ResponseBody
    public List<Usuario> listarOrdenRecepcion() {
        return usuarioServices.listarUsuarios();
    }
}