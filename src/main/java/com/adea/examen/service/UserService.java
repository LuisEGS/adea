package com.adea.examen.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adea.examen.data.Usuarios;
import com.adea.examen.data.UsuarioRepository;
import com.adea.examen.dto.LoginDTO;
import com.adea.examen.dto.ObjResponse;
import com.adea.examen.dto.UsuarioDTO;
import com.google.gson.Gson;

@Service
public class UserService {
	/*
	String originalInput = "test input";
	String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
	String decodedString = new String(Base64.decodeBase64(encodedString.getBytes()));
	*/
	
	@Autowired(required=true)
	UsuarioRepository repo;
	
	public ObjResponse ListaUsuario() {
		ObjResponse result = new ObjResponse();
		HashMap<String, Object> map = new HashMap<>();
		map.put("Usuario", repo.findAll());
		result.setData(map);
		
		return result;
	}
	
	
	public ObjResponse LoginUsuario(String strLogin) {
		ObjResponse result = new ObjResponse();
		HashMap<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		LoginDTO login = gson.fromJson(strLogin, LoginDTO.class); 
		
		Usuarios usuario = repo.findByUsuario(login.getUsuario() );
		
		if(usuario == null) {
			result.setError(true);
			result.setErrorDesc("El usuario no existe");
		}
		if(!result.isError()){
			String strPassword = login.getPassword();
			String encoded = new String(Base64.encodeBase64(strPassword.getBytes()));
			usuario = repo.findByUsuarioAndPassword(login.getUsuario(),encoded);
			
			if (usuario == null) {
				result.setError(true);
				result.setErrorDesc("Clave invalida");				
			}else {
				if(usuario.getFechaVigencia() == null) {
					
				} else {
					Date date = new Date();
					Date vigencia =usuario.getFechaVigencia(); 

				} 
				
			}
		}

		
		
		
		return result;
	}
	
	
	public Map<String, Object> DatatableUsuarios() {
		HashMap<String, Object> result = new HashMap<>();
		result.put("data", repo.findAll());
		return result;
	}
	
	public Map<String, Object> DatatableUsuariosByStatus(String status) {
		HashMap<String, Object> result = new HashMap<>();
		result.put("data", repo.findByStatus(status));
		return result;
	}	
	
	
	public ObjResponse nuevoUsuario(String strUsuario) {
		ObjResponse result = new ObjResponse();
		HashMap<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsuarioDTO usuarioDTO = gson.fromJson(strUsuario, UsuarioDTO.class);
		Usuarios actualUsuario =  new Usuarios();
		updateData(usuarioDTO,actualUsuario );
		Usuarios nuevoUsuario = repo.save(actualUsuario);
		map.put("data", nuevoUsuario);
		result.setData(map);
		return result;
	}

	public ObjResponse editaUsuario(String strUsuario, String strId ) {
		ObjResponse result = new ObjResponse();
		HashMap<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsuarioDTO usuarioDTO = gson.fromJson(strUsuario, UsuarioDTO.class);
		Usuarios actualUsuario = repo.findByUsuario(strId );
		updateData(usuarioDTO,actualUsuario );
		Usuarios nuevoUsuario = repo.save(actualUsuario);
		map.put("data", nuevoUsuario);
		result.setData(map);
		return result;
	}
	
	public ObjResponse borrarUsuario( String strId ) {
		ObjResponse result = new ObjResponse();
		HashMap<String, Object> map = new HashMap<>();
		Usuarios actualUsuario = repo.findByUsuario(strId );

		//repo.delete(actualUsuario);
		map.put("data", "borrado");
		result.setData(map);
		return result;
	}

	public ObjResponse editaUsuarioGestion(String strUsuario, String strId ) {
		ObjResponse result = new ObjResponse();
		HashMap<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsuarioDTO usuarioDTO = gson.fromJson(strUsuario, UsuarioDTO.class);
		Usuarios actualUsuario = repo.findByUsuario(strId );
		actualUsuario.setStatus(usuarioDTO.getStatus() );
		
		Usuarios nuevoUsuario = repo.save(actualUsuario);
		map.put("data", nuevoUsuario);
		result.setData(map);
		return result;
	}
	
	private void updateData(UsuarioDTO usuarioDTO,Usuarios usuarios) {
		usuarios.setUsuarioId(usuarioDTO.getUsuarioId());
		usuarios.setPassword(usuarioDTO.getPassword());
		usuarios.setNombre(usuarioDTO.getNombre());
		usuarios.setCliente(usuarioDTO.getCliente());
		usuarios.setEmail(usuarioDTO.getEmail());
		usuarios.setFechaAlta(usuarioDTO.getFechaAlta());
		usuarios.setFechaBaja(usuarioDTO.getFechaBaja());
		usuarios.setStatus(usuarioDTO.getStatus());
		usuarios.setIntentos(usuarioDTO.getIntentos());
		usuarios.setFechaRevocado(usuarioDTO.getFechaRevocado());
		usuarios.setFechaVigencia(usuarioDTO.getFechaVigencia());
		usuarios.setNoAcceso(usuarioDTO.getNoAcceso());
		usuarios.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
		usuarios.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
		usuarios.setArea(usuarioDTO.getArea());
		usuarios.setFechaModificacion(usuarioDTO.getFechaModificacion());
		
		String strPassword = usuarioDTO.getPassword();
		String encoded = new String(Base64.encodeBase64(strPassword.getBytes()));
		
		usuarios.setPassword(encoded);
	}
	
	
	
}
