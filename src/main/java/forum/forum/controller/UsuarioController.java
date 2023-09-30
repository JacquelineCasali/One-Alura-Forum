package forum.forum.controller;

import forum.forum.domain.Usuario.Usuario;
import forum.forum.domain.Usuario.UsuarioRepository;
import forum.forum.dto.Usuario.DaddosDetalhamentoUsuario;
import forum.forum.dto.Usuario.DadosAtualizarUsuario;
import forum.forum.dto.Usuario.DadosCadastroUsuario;
import forum.forum.dto.Usuario.DadosListagemUsuario;
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
@RequestMapping("/")
public class UsuarioController {

        // para instanciar a classe
        @Autowired
        private UsuarioRepository repository;

// inserir dados

        @PostMapping
        // transação ativa com o banco de dados
        @Transactional
//    RequestBody corpo da requisição corpo interiro
        public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados ,UriComponentsBuilder uriBuilder){
         var usuario= new Usuario(dados);


            repository.save(usuario);
            var uri= uriBuilder.path("/{id}").buildAndExpand(usuario.getId()).toUri();
            return  ResponseEntity.created(uri).body(new DaddosDetalhamentoUsuario(usuario));
        }



        // listar usuarios
    // size quantidade de registro na pagina
        // sort = ordenado pelo nome
//findAllByAtivoTrue traz so os ativos
        @GetMapping
        public ResponseEntity <Page<DadosListagemUsuario>> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){

            var page= repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuario::new);
            return  ResponseEntity.ok(page);

        }





    // atualizar
    @Transactional
    @PutMapping
    public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizarUsuario dados){
        var usuario=repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
        return  ResponseEntity.ok(new DaddosDetalhamentoUsuario(usuario));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public  ResponseEntity  excluir(@PathVariable Long id){
        var usuario=repository.getReferenceById(id);
        usuario.excluir();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public  ResponseEntity  detalhar(@PathVariable Long id){
        var usuario=repository.getReferenceById(id);

        return ResponseEntity.ok(new DaddosDetalhamentoUsuario(usuario));
    }
    }




