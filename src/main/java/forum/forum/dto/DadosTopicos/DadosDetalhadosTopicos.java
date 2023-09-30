package forum.forum.dto.DadosTopicos;

import forum.forum.domain.Topico.Topico;
import forum.forum.dto.Curso.Curso;
import forum.forum.dto.Status.Status;


public record DadosDetalhadosTopicos(
      Long Id,
        String titulo,

        String mensagem,

        Status status,

        String autor ,

        Curso curso
) {



    public  DadosDetalhadosTopicos(Topico topico) {
this(topico.getId(),topico.getTitulo(), topico.getMensagem(), topico.getStatus(),topico.getAutor(),topico.getCurso());


    }
}
