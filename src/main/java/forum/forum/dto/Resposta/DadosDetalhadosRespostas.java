//package forum.forum.dto.Resposta;
//
//import forum.forum.domain.Resposta.Resposta;
//
//import java.time.LocalDateTime;
//
//public record DadosDetalhadosRespostas(
//
//        Long id,
//        String message,
//        LocalDateTime creationDate,
//        Long autorId,
//        Long topicoId,
//        Boolean solution
//
//
//) {
//    public DadosDetalhadosRespostas(Resposta resposta) {
//        this(resposta.getId(), resposta.getMensagem(), resposta.getCreationDate(),
//                resposta.getTopico().getId(),resposta.getAutor().getId(),resposta.getSolution());
//    }
//}
