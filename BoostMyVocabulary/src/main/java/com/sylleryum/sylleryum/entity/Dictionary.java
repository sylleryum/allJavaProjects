package com.sylleryum.sylleryum.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String language;
    @ManyToOne
    private ApiUser user;
    @CreationTimestamp
    private LocalDateTime dateAdded;
    @OneToMany(
            mappedBy = "dictionary",
            cascade = CascadeType.ALL)
    private List<Word> words;

    public Dictionary() {
    }

    public Dictionary(String language, ApiUser user, LocalDateTime dateAdded, List<Word> words) {
        this.language = language;
        this.user = user;
        this.dateAdded = dateAdded;
        this.words = words;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ApiUser getUser() {
        return user;
    }

    public void setUser(ApiUser user) {
        this.user = user;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
