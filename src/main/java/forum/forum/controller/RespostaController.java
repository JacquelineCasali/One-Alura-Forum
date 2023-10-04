//package forum.forum.controller;
//
//import forum.forum.domain.Resposta.Resposta;
//import forum.forum.domain.Resposta.RespotaRepository;
//import forum.forum.domain.Resposta.RespotaTopico;
//import forum.forum.dto.DadosTopicos.DadosTopicos;
//import forum.forum.dto.Resposta.DadosDetalhadosRespostas;
//import forum.forum.dto.Resposta.DadosResposta;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@RestController
//@RequestMapping("respostas")
//public class RespostaController {
//
//    @Autowired
//    private RespotaTopico resposta;
//@PostMapping
//@Transactional
//public ResponseEntity responde(@RequestBody @Valid DadosResposta dados){
//
//var respostaTopico = resposta.responde(dados);
//    return ResponseEntity.ok(respostaTopico);
//}
//}
