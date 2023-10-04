//package forum.forum.domain.Resposta;
//
//import forum.forum.domain.Topico.TopicoRepository;
//import forum.forum.dto.Resposta.DadosResposta;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RespotaTopico {
//
//    @Autowired
//    TopicoRepository topicoRepository;
//    @Autowired
//    RespotaRepository respotaRepository;
//    public ResponseEntity responde (DadosResposta dados){
//      var topico = topicoRepository.getReferenceById(dados.topico());
//
//        var newResposta= new Resposta(
//                dados.mensagem(),
//                topico,
//                autor
//        );
//        // Salva o novo tópico no repositório
//        respotaRepository.save(newResposta);
//
//        return  ResponseEntity.status(HttpStatus.CREATED).build();
//
//    }
//}
