package br.com.forum.forum.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Table(name = "postagens")
@Entity(name = "Forum")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDate data;


    public Forum(DadosForum dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDate.now();
    }

    public void atualizarPostagem(DadosAtualizarForum dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDate.now();
    }

    public void setId(Long id) {
        this.id = id;
    }
}
