package com.example.examen.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.examen.entity.Pedido;
import com.example.examen.entity.Plato;
import com.example.examen.entity.Usuario;
import com.example.examen.service.PedidoService;
import com.example.examen.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuario;
	
	@Autowired
	private PedidoService pedidoS;
	
	@GetMapping
	public String inicio (Model model) {
		List<Pedido> lista = new ArrayList<Pedido>();
		try {
			 /*lista = pedido.findById();*/
		} catch (Exception e) {;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("pedidos", lista);
		return "usuario/inicio";
		
	}
	
	
	@GetMapping("pedido/nuevo")
	public String nuevo(Model model, SessionStatus session) {
		Pedido pedido = new Pedido();
		pedido.setEstado("no confirmado");
		try {
			Optional<Usuario> optional = usuario.findById(1);
			if (optional.isPresent()) {
				pedido.setUsuario(optional.get());
			} else {
				return "usuario/inicio";
			}
			pedidoS.save(pedido);
			session.setComplete();
			List<Pedido> lista = new ArrayList<Pedido>();
			try {
				 /*lista = pedido.findById();*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("pedidos", lista);
			return "index";
		} catch (Exception e) {
			// TODO: handle exception
			return "usuario/nuevo";
		}


	}
	

	
}
