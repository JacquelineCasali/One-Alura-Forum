package forum.forum.infra.Security;

import forum.forum.domain.Usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// chama a requisição
@Component
public class SecurityFilter  extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // recuperar o token no cabeçalho
        var tokenJWT= recuperarToken(request);
     // validação do token
//validar token
     if(tokenJWT !=null){
         var subject= tokenService.getSubject(tokenJWT);
         // considerando logado
         var usuario = repository.findByLogin(subject);

         var authorization = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
         SecurityContextHolder.getContext().setAuthentication(authorization);
         System.out.println("Logado");
     }

        // sequir o fluxo da requisiçao
        filterChain.doFilter(request,response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader =request.getHeader("Authorization");
        // validação
        if(authorizationHeader !=null){
            return authorizationHeader.replace("Bearer ", "");
        }
        return  null;
    }
}
