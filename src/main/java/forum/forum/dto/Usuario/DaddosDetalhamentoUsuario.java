package forum.forum.dto.Usuario;

import forum.forum.domain.Usuario.Usuario;

import jakarta.validation.constraints.Pattern;

public record DaddosDetalhamentoUsuario(
        Long id,
        String nome,

        String email ,

        @Pattern(regexp = "\\d{4,10}")
        String senha

) {


    public  DaddosDetalhamentoUsuario(Usuario usuario) {

        this(usuario.getId(),usuario.getNome(),usuario.getEmail(),usuario.getSenha());
    }
}
