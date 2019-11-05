package com.example.examen.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.examen.entity.Plato;
import com.example.examen.service.PlatoService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired 
	private PlatoService plato;
	
	@GetMapping
	public String inicio (Model model) {
		List<Plato> lista = new ArrayList<Plato>();
		try {
			 lista = plato.findAll();
		} catch (Exception e) {;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("platos", lista);
		return "index";
		
	}
	
	
	@GetMapping("plato/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> optional = plato.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("plato", optional.get());
			} else {
				return "redirect:/plato";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "plato/nuevo";
	}

	@PostMapping("plato/save")
	public String save(@ModelAttribute("plato") Plato platito, Model model, SessionStatus status) {
		List<Plato> lista = new ArrayList<Plato>();
		
		try {
			plato.save(platito);
			status.setComplete();
			
			try {
				 lista = plato.findAll();
			} catch (Exception e) {;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("platos", lista);
		return "index";
	}

	@GetMapping("plato/nuevo")
	public String nuevo(Model model) {
		Plato plato = new Plato();
		model.addAttribute("plato", plato);
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "plato/nuevo";
	}

	@GetMapping("plato/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> platoO = plato.findById(id);
			if (platoO.isPresent()) {
				plato.deleteById(id);
			}
		} catch (Exception e) {

			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Plato> platos = plato.findAll();
				model.addAttribute("platos", platos);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "index";
		}
		return "index";
	}

	
	
	
}
