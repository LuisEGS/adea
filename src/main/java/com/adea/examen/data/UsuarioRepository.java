package com.adea.examen.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, String> {
	Usuarios findByUsuario(String Usuario);
	Usuarios findByUsuarioAndPassword(String Usuario, String Password);
	List<Usuarios> findByStatus(String status);

}
