package forum.forum.dto.DadosTopicos;


import forum.forum.dto.Curso.Curso;
import forum.forum.dto.Status.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// import java.time.LocalDateTime;

public record DadosTopicos(
        // faz a validação @notblack não é nulo nem vazio
        @NotBlank(message = "Titulo é obrigatório")
        String titulo,
        @NotBlank(message = "Campo mensagem é obrigatório")
        String mensagem,
        @NotNull
        Status status,
        @NotBlank
        String autor ,
        @NotNull
        Curso curso) {
}
