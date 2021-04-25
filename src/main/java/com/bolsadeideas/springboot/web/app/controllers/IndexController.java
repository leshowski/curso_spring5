package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index","/home","/"})
	public String index(Model model) {
		
		model.addAttribute("titulo","Hola Spring Framework!");
		
		return "index";
		
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Luis");
		usuario.setApellido("Ponce");
		usuario.setEmail("luis.ponce@uc.cl");
		
		model.addAttribute("titulo","Perfil de usuario:"+usuario.getNombre()+ " "+usuario.getApellido());
		model.addAttribute("usuario",usuario);
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		model.addAttribute("titulo","Lista de usuarios");
		model.addAttribute("usuarios",usuarios);
		
		return "listar";
	}
}
