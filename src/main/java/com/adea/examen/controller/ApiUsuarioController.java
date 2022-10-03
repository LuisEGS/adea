package com.adea.examen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adea.examen.dto.ObjResponse;
import com.adea.examen.service.UserService;

@RestController
public class ApiUsuarioController {
	
		
	@Autowired(required=true)
	UserService userService;
	
	@GetMapping("api/usuarios")
	ObjResponse usuariosList() {
		return userService.ListaUsuario();
	}
	
	@PostMapping("api/Login")
	ObjResponse login(@RequestBody String strLogin) {
		return userService.LoginUsuario(strLogin);
	}
	
	@GetMapping("api/datatable/usuarios")
	Map<String, Object> datatableUsuarios(){
		return userService.DatatableUsuarios();
	}

	@GetMapping("api/datatable/usuarios/{status}")
	Map<String, Object> datatableUsuariosTipo(@PathVariable String status){
		return userService.DatatableUsuariosByStatus(status);
	}

	@PostMapping("api/Tablero")
	ObjResponse newTablero(@RequestBody String strtablero) {
		return userService.nuevoUsuario(strtablero);
	}
	
	@PutMapping("api/Tablero/{id}")
	ObjResponse newTablero(@RequestBody String strtablero, @PathVariable String id) {
		return userService.editaUsuario(strtablero,id);
	}
	
	@DeleteMapping("api/Tablero/{id}")
	void borrarTablero(@PathVariable String id) {
		return ;
	}
	
	@PutMapping("api/Gestion/{id}")
	ObjResponse newGestion(@RequestBody String strtablero, @PathVariable String id) {
		return userService.editaUsuarioGestion(strtablero,id);
	}
	
	
}
