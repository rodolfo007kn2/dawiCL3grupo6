package com.cibertec.dawiCL3grupo6.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.dawiCL3grupo6.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	Rol findByNomrol(String rolname);

}
