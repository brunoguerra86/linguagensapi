package br.com.bg8.linguagensapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @PostMapping("/linguagens")
    public ResponseEntity<Linguagem> criarLinguagem(@RequestBody Linguagem linguagem){
        return new ResponseEntity<>(repositorio.save(linguagem), HttpStatus.CREATED);
    }

    @GetMapping("/linguagens")
    public List<Linguagem> lerLinguagem(){
        return repositorio.findByOrderByRanking();
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
