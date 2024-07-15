package br.com.forum.forum.model;

import java.time.LocalDate;

public record DadosAtualizarForum (String titulo,
                                  String mensagem,
                                  LocalDate date){
}
