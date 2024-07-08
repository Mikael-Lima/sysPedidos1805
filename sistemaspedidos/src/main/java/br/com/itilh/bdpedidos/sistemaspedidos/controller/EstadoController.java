package br.com.itilh.bdpedidos.sistemaspedidos.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import br.com.itilh.bdpedidos.sistemaspedidos.model.Estado;
import br.com.itilh.bdpedidos.sistemaspedidos.repository.EstadoRepository; 


@RestController
public class EstadoController {

    private final EstadoRepository repositorio;

    public EstadoController(EstadoRepository repositorio){
        this.repositorio=repositorio;
    }

    @GetMapping("/estados")
    public List<Estado> getTodos() {
        return (List<Estado>) repositorio.findAll();
    }
    
    @GetMapping("/estado/{id}")
    public Estado getPorId(@PathVariable BigInteger id) throws Exception {
        return repositorio.findById(id).orElseThrow(
            () -> new Exception("ID inválido.")
         );
    }    

    @PostMapping("/estado")
    public Estado criarEstado(@RequestBody Estado entity){ 
        return repositorio.save(entity);
        
    }

    @PutMapping("/estado/{id}")
    public Estado alterarEstado(@PathVariable BigInteger id, 
                                @RequestBody Estado novosDados) throws Exception {

        Optional<Estado> estadoAmazenado = repositorio.findById(id);
        if(estadoAmazenado.isPresent()){
            //Atribuir novo nome ao objeto já existem no banco de dados
            estadoAmazenado.get().setNome(novosDados.getNome());
            //
            return repositorio.save(estadoAmazenado.get());
        }        
        throw new Exception("Alteração não foi realizada.");
    }
    
    @DeleteMapping("/estado/{id}")
    public String deletePorId(@PathVariable BigInteger id) throws Exception {

        Optional<Estado> estadoAmazenado = repositorio.findById(id);
        if(estadoAmazenado.isPresent()){
            repositorio.delete(estadoAmazenado.get());
            return "Excluído";
        }
        throw new Exception("Id não econtrado para a exclusão");
    }    
    
    
    
}
