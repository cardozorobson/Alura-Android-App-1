package com.example.robson.agenda.modelo;

import java.io.Serializable;

/**
 * Created by Robson on 11/2/2017.
 */

public class Aluno implements Serializable{

    private Long id;
    private String nome;
    private String end;
    private String fone;
    private String site;
    private Double nota;

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
