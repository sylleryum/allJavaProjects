package com.sylleryum.hateoasimplementer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sylleryum.hateoasimplementer.assemblers.HATEOASBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
public class SampleEntity extends HATEOASBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String uf;
    @OneToMany(
            mappedBy = "",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SampleNestedEntity> cidades;

    public SampleEntity() {
    }

    public SampleEntity(String nome, String uf, List<SampleNestedEntity> cidades) {
        this.nome = nome;
        this.uf = uf;
        this.cidades = cidades;
    }

    @Override
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<SampleNestedEntity> getCidades() {
        return cidades;
    }

    public void setCidades(List<SampleNestedEntity> cidades) {
        this.cidades = cidades;
    }
}
