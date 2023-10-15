package com.jotaempresas.curso_springBoot.resources;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class PagesResource {

	
    public String index() {
        return "index"; // Retorna o nome do arquivo HTML (sem a extensão)
    }
}