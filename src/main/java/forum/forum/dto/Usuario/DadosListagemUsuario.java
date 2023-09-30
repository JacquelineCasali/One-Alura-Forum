package forum.forum.dto.Usuario;

import forum.forum.domain.Usuario.Usuario;


public record DadosListagemUsuario(
        Long id,
        String nome,
              String email

) {
    // cria o construtor
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(),
                usuario.getNome(), usuario.getEmail());
    }

}
