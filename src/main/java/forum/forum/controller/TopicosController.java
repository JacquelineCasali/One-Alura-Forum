package forum.forum.controller;

import forum.forum.domain.Topico.Topico;
import forum.forum.domain.Topico.TopicoRepository;
import forum.forum.dto.DadosTopicos.DadosAtualizarTopicos;
import forum.forum.dto.DadosTopicos.DadosDetalhadosTopicos;
import forum.forum.dto.DadosTopicos.DadosListaTopicos;
import forum.forum.dto.DadosTopicos.DadosTopicos;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
// endereço
@RequestMapping("topicos")
//todos os dados precisa de autenticação
@SecurityRequirement(name = "bearer-key")
public class TopicosController {

    // para instanciar a classe
    @Autowired
    private TopicoRepository repository;

// inserir dados

    @PostMapping
    // transação ativa com o banco de dados
    @Transactional
//    RequestBody corpo da requisição corpo interiro
    // ResponseEntity codigo da mensagem
    public ResponseEntity cadastrar(@RequestBody @Valid DadosTopicos dados , UriComponentsBuilder uriBuilder ){
var topico= new  Topico(dados);
        repository.save(topico);
        var uri= uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhadosTopicos(topico));

    }
    // ler
    //Pageable quantidade de items na pagina
    // size quantidade de registro na pagina
    // sort = ordenado pelo nome
    //findAllByAtivoTrue traz so os ativos
    @GetMapping
    public ResponseEntity <Page<DadosListaTopicos>> listar(@PageableDefault(size=10, sort={"titulo"}) Pageable paginacao){
var topico=  repository.findAllByAtivoTrue(paginacao).map(DadosListaTopicos::new);
return  ResponseEntity.ok(topico);
    }


    // atualizar
    @Transactional
    @PutMapping
    public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizarTopicos dados){
var topico=repository.getReferenceById(dados.id());
topico.atualizarInformacoes(dados);
return  ResponseEntity.ok(new DadosDetalhadosTopicos(topico));
    }

    // invalidar
    @Transactional
    @DeleteMapping("/{id}")
    public  ResponseEntity  excluir(@PathVariable Long id){
var topico=repository.getReferenceById(id);
    topico.excluir();
    return  ResponseEntity.noContent().build();
    }
    // detalhar
    @GetMapping("/{id}")
    public  ResponseEntity detalhar(@PathVariable Long id){
        var topico=repository.getReferenceById(id);
        return  ResponseEntity.ok(new DadosDetalhadosTopicos(topico));
    }

}
