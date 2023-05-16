package com.cl2.palomino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cl2.palomino.entity.Sucursal;
import com.cl2.palomino.entity.Supervisor;
import com.cl2.palomino.service.SucursalService;
import com.cl2.palomino.service.SupervisorService;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

	@Autowired
	private SupervisorService serviceSup;
	
	@Autowired
	private SucursalService serviceSuc;
	
	@RequestMapping("/listado")
	public String lista(Model model) {
		
		model.addAttribute("supervisores",serviceSup.listarSupervisores());
		model.addAttribute("sucursales",serviceSuc.listarSucursal());
		
		return "supervisor";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Supervisor buscar(@RequestParam("codigo") Integer cod) {
		return serviceSup.buscarPorID(cod);
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("apellido") String ape,
			@RequestParam("dni") int dni,
			@RequestParam("hijos") int hijos,
			@RequestParam("sueldo") double sueldo,
			@RequestParam("sucursal") int codSucursal,
			RedirectAttributes redirect) {
		try {
			Supervisor s = new Supervisor();
			s.setCodigo(cod);
			s.setNombre(nom);
			s.setApellido(ape);
			s.setDni(dni);
			s.setHijos(hijos);
			s.setSueldo(sueldo);
			Sucursal sus= new Sucursal();
			sus.setCodigo(codSucursal);
			s.setSucursal(sus);
			
			serviceSup.actualizar(s);
			
			redirect.addFlashAttribute("MENSAJE","Supervisor actualizado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la actualización");
			e.printStackTrace();
		}
		return "redirect:/supervisor/listado";
	}
	
}
