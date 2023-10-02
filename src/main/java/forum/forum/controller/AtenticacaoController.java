package forum.forum.controller;

import forum.forum.domain.Usuario.DadoAutenticacao;
import forum.forum.domain.Usuario.Usuario;
import forum.forum.infra.Security.TokenService;
import forum.forum.infra.Security.DadosTokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AtenticacaoController {
    //chama o processo de autenticação AuthenticationManager configra no security
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity efetuarlogin (@RequestBody @Valid DadoAutenticacao dados){



var AutenticacaoToken= new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var autenticacao =manager.authenticate(AutenticacaoToken);
     var tokenJWT=tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return  ResponseEntity.ok(new DadosTokenJWT(tokenJWT));





    }


}
