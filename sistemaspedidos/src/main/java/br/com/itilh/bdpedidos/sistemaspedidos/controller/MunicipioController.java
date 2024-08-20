package br.com.itilh.bdpedidos.sistemaspedidos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itilh.bdpedidos.sistemaspedidos.model.Municipio;
import br.com.itilh.bdpedidos.sistemaspedidos.repository.MunicipioRepository;



@RestController
public class MunicipioController {


    private final MunicipioRepository repositorio;

    public MunicipioController( MunicipioRepository repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/municipios")
    public List <Municipio> getTodos() {
        return (List<Municipio>) repositorio.findAll();
        
    }
    
}
