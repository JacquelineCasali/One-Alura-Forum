package forum.forum.controller;

import forum.forum.Topico.Topico;
import forum.forum.Topico.TopicoRepository;
import forum.forum.dto.DadosTopicos.DadosTopicos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// endereço
@RequestMapping("/")
public class TopicosController {

    // para instanciar a classe
    @Autowired
    private TopicoRepository repository;

// inserir dados

    @PostMapping
    // transação ativa com o banco de dados
    @Transactional
//    RequestBody corpo da requisição corpo interiro
    public void  cadastrar(@RequestBody @Valid DadosTopicos dados){
repository.save(new Topico(dados));

    }
}
