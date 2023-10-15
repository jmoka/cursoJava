package com.jotaempresas.curso_springBoot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jotaempresas.curso_springBoot.entites.User;
import com.jotaempresas.curso_springBoot.servicies.UserService;
import org.springframework.ui.Model;


@Controller
public class FormResource {
    @Autowired
    private UserService userService;

    @PostMapping("/inserir")
    public String inserir(@RequestParam("name") String nome, 
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password, Model model) {
    	
        try {
            User user = new User(null, nome, email, phone, password);
            userService.insert(user);
            model.addAttribute("mensagem", "Cadastro Efetuado");
            return "redirect:/sucesso"; // Redirecione para a página de sucesso (success.jsp)
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro no Cadastro: " + e);
            return "redirect:/sucesso"; // Redirecione para a página de erro (error.jsp)
        }
    }

}
