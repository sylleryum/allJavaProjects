package com.sylleryum.sylleryum.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class GrammarCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    @OneToMany(
            mappedBy = "grammarCategory",
            cascade = CascadeType.ALL)
    private List<Word> words;

    public GrammarCategory() {
    }

    public GrammarCategory(Long id, String category, List<Word> words) {
        this.id = id;
        this.category = category;
        this.words = words;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
