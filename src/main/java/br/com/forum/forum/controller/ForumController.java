package br.com.forum.forum.controller;

import br.com.forum.forum.model.DadosAtualizarForum;
import br.com.forum.forum.model.DadosForum;
import br.com.forum.forum.model.Forum;
import br.com.forum.forum.repository.ForumRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("forum")
public class ForumController {
    @Autowired
    private ForumRepository repository;

    @PostMapping
    @Transactional
    public void cadastar(@RequestBody DadosForum dados){
       repository.save(new Forum(dados));
    }

    @GetMapping
    public List<Forum> listar(){
        return repository.findAll();
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    @Transactional

    public void atualizar (@PathVariable Long id,  @RequestBody DadosAtualizarForum dados){
        var forum = repository.getReferenceById(id);
        forum.atualizarPostagem(dados);
    }

    @GetMapping("{id}")
    public Optional<Forum> pegarUm(@PathVariable Long id){
        return repository.findById(id);
    }
}
