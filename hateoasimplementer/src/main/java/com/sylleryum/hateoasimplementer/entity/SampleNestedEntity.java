package com.sylleryum.hateoasimplementer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sylleryum.hateoasimplementer.assemblers.HATEOASBuilder;

import javax.persistence.*;

@Entity
public class SampleNestedEntity extends HATEOASBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SampleNestedEntity_id")
    @JsonBackReference
    private SampleEntity sampleEntity;

    /**
     * as sampleEntity won't be serialized into a JSON to avoid stackoverflow, at least we can serialize some desired fields from the entity
     * @return
     */
    public String getNomeFromSampleEntity() {
        return sampleEntity.getNome();
    }

    public SampleNestedEntity() {
    }

    public SampleNestedEntity(String nome, SampleEntity sampleEntity) {
        this.nome = nome;
        this.sampleEntity = sampleEntity;
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

    public SampleEntity getSampleEntity() {
        return sampleEntity;
    }

    public void setSampleEntity(SampleEntity sampleEntity) {
        this.sampleEntity = sampleEntity;
    }
}
