package com.cibertec.dawiCL3grupo6.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.dawiCL3grupo6.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

	Usuario findByNomusuario(String username);
}
