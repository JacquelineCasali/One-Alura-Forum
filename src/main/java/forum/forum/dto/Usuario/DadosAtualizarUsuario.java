package forum.forum.dto.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(

        @NotNull
        Long id,
        @Email
        String email,
        String senha
) {

}
