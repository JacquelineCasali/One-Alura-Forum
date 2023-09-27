package forum.forum.Topico;

import forum.forum.dto.Curso.Curso;
import forum.forum.dto.DadosTopicos.DadosTopicos;
import forum.forum.dto.Status.Status;
import jakarta.persistence.*;
import lombok.*;

 import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "Topico")
@Table(name= "topicos")
@EqualsAndHashCode(of= "id")

public class Topico
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private  Long id;
 private  String titulo;
 private String mensagem;
 @Column(name = "data_criacao")
 private LocalDateTime dataCriacao;
 @Enumerated(EnumType.STRING)
 private Status status;

 private  String autor;

 @Enumerated(EnumType.STRING)
 private Curso curso;

 public Topico(DadosTopicos dados) {
  this.titulo=dados.titulo();
  this.mensagem =dados.mensagem();
  this.dataCriacao = LocalDateTime.now();
  this.status=dados.status();
  this.autor=dados.autor();
  this.curso = dados.curso();






 }
}
