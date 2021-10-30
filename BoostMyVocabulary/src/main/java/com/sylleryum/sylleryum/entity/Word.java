package com.sylleryum.sylleryum.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String originalWord;
    private String translation;
    @CreationTimestamp
    private LocalDateTime dateAdded;
    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    private Dictionary dictionary;
    @OneToOne
    @JoinColumn(name = "wordProgress_id", referencedColumnName = "id")
    private WordProgress wordProgress;
    @ManyToOne
    @JoinColumn(name = "grammarCategory_id")
    private GrammarCategory grammarCategory;


    public Word() {
    }

    public Word(Long id, String originalWord, String translation, LocalDateTime dateAdded, Dictionary dictionary, WordProgress wordProgress, GrammarCategory grammarCategory) {
        this.id = id;
        this.originalWord = originalWord;
        this.translation = translation;
        this.dateAdded = dateAdded;
        this.dictionary = dictionary;
        this.wordProgress = wordProgress;
        this.grammarCategory = grammarCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public WordProgress getWordProgress() {
        return wordProgress;
    }

    public void setWordProgress(WordProgress wordProgress) {
        this.wordProgress = wordProgress;
    }

    public GrammarCategory getGrammarCategory() {
        return grammarCategory;
    }

    public void setGrammarCategory(GrammarCategory grammarCategory) {
        this.grammarCategory = grammarCategory;
    }
}
