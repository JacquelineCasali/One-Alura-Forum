package forum.forum.dto.DadosTopicos;

import forum.forum.domain.Topico.Topico;
import forum.forum.dto.Curso.Curso;
import forum.forum.dto.Status.Status;

import java.time.LocalDateTime;


public record DadosListaTopicos(
        // faz a validação @notblack não é nulo nem vazio
Long id,
        String titulo,

        String mensagem,

        LocalDateTime data_criacao,

        Status status,

        String autor ,

        Curso curso
) {
public  DadosListaTopicos(Topico topico){
    this(topico.getId(),topico.getTitulo(), topico.getMensagem() , topico.getDataCriacao(),   topico.getStatus(),topico.getAutor(),topico.getCurso());
}


}
