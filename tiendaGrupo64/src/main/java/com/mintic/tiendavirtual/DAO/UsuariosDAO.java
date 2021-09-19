package com.mintic.tiendavirtual.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mintic.tiendavirtual.modelo.Usuarios;

public interface UsuariosDAO extends JpaRepository<Usuarios, Integer>{
	
}
