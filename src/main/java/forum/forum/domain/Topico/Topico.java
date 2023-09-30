package forum.forum.domain.Topico;

import forum.forum.dto.Curso.Curso;
import forum.forum.dto.DadosTopicos.DadosAtualizarTopicos;
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
 private Curso Curso;
 private  boolean ativo;
 public Topico(DadosTopicos dados) {

  this.ativo=true;
  this.titulo=dados.titulo();
  this.mensagem =dados.mensagem();
  this.dataCriacao = LocalDateTime.now();
  this.status=dados.status();
  this.autor=dados.autor();
  this.Curso = dados.curso();

 }

 public void atualizarInformacoes(DadosAtualizarTopicos dados) {
  if(dados.titulo() !=null){
   this.titulo= dados.titulo();
  }

  if(dados.mensagem() !=null){
   this.mensagem= dados.mensagem();
  }
  if(dados.status() !=null){
   this.status = dados.status();
  }

 }




 public void excluir() {
  this.ativo=false;
 }
}
