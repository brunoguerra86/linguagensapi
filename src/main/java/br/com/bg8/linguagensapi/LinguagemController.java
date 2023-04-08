package br.com.bg8.linguagensapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;


    @PostMapping("/linguagens")
    public Linguagem criarLinguagem(@RequestBody Linguagem linguagem){
        return repositorio.save(linguagem);
    }

    @GetMapping("/linguagens")
    public List<Linguagem> lerLinguagem(){
        return repositorio.findAll();
    }

    @GetMapping("linguagens/{id}")
    public Linguagem lerLinguagemPorId(@PathVariable String id){
        return repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("linguagens/{id}")
    public Linguagem atualizarLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem){

        if(!repositorio.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        linguagem.setId(id);
        return repositorio.save(linguagem);
    }

    @DeleteMapping("linguagens/{id}")
    public void excluirLinguagem(@PathVariable String id){
        repositorio.deleteById(id);
    }

}
