//package forum.forum.domain.Resposta;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import forum.forum.domain.Topico.Topico;
//import forum.forum.domain.Usuario.Usuario;
//import forum.forum.dto.Resposta.DadosResposta;
//import jakarta.persistence.*;
//import jakarta.validation.Valid;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Entity(name = "Resposta")
//
//@Table(name= "respostas")
//@EqualsAndHashCode(of= "id")
//
//public class Resposta {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String mensagem;
//    private LocalDateTime creationDate = LocalDateTime.now();
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="autor_id")
//    private Usuario autor;
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="topico_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Topico topico;
//    private Boolean solution = false;
//
//
//
//    public Resposta(String mensagem, Topico topico, Usuario autor) {
//
//        this.mensagem =mensagem;
//        this.topico = topico;
//        this.autor= autor;
//
//    }
//}
