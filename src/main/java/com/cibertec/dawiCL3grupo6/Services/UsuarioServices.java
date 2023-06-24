package com.cibertec.dawiCL3grupo6.Services;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.cibertec.dawiCL3grupo6.Repositorys.RolRepository;
import com.cibertec.dawiCL3grupo6.Repositorys.UsuarioRepository;
import com.cibertec.dawiCL3grupo6.model.bd.Rol;
import com.cibertec.dawiCL3grupo6.model.bd.Usuario;


@Service
public class UsuarioServices {

	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public Usuario buscarUsuarioPorNomusuario(String nomusuario) {
		return usuarioRepository.findByNomusuario(nomusuario);
	}

	public Usuario guardarUsuario(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		
		usuario.setActivo(true);
		Rol rol = rolRepository.findByNomrol("digitador");
		usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
		return usuarioRepository.save(usuario);
	}
}