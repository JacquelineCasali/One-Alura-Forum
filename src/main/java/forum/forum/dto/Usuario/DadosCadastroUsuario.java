package forum.forum.dto.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email ,
        @NotBlank(message = "Senha é obrigatória")
        @Pattern(regexp = "\\d{4,10}", message = "Formato da Senha é inválido")
        String senha) {


}
