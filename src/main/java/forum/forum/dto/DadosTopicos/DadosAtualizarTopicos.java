package forum.forum.dto.DadosTopicos;


import forum.forum.dto.Curso.Curso;
import forum.forum.dto.Status.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopicos(
        @NotNull
        Long id,
        String titulo,

        String mensagem,
        Status status

) {
}
