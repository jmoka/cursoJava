package com.jotaempresas.curso_springBoot.resources;



import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jotaempresas.curso_springBoot.entites.User;
import com.jotaempresas.curso_springBoot.servicies.UserService;


@Controller
public class PagesResource {

	@RequestMapping(value = "/")
	public String index() {
	    return "redirect:/index.html";
	}
	@RequestMapping(value = "/consultar")
	public String index2() {
	    return "redirect:/index2.html";
	}
    
	@PostMapping("/usuario")
    public String usuario(@RequestParam("numero") String numero) {
        System.out.println("Número digitado: " + numero);
        return "redirect:/users/"+numero;
    }
	
	@PostMapping("/pedido")
    public String pedido(@RequestParam("numero") String numero) {
        System.out.println("Número digitado: " + numero);
        return "redirect:/orders/"+numero;
    }
	
	@PostMapping("/produto")
    public String produto(@RequestParam("numero") String numero) {
        System.out.println("Número digitado: " + numero);
        return "redirect:/products/"+numero;
    }
	
	@PostMapping("/categoria")
    public String categoria(@RequestParam("numero") String numero) {
        System.out.println("Número digitado: " + numero);
        return "redirect:/categories/"+numero;
    }
	
	
	@RequestMapping(value="/formulario")
    public String formulario() {
        return "redirect:/index3.html/";
    }
	
	@RequestMapping(value="/sucesso")
    public String sucesso() {
        return "redirect:/msgSucesso.html/";
    }
	
	   
	
	   
 
}