package com.sylleryum.sylleryum.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WordProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int timesReviewed;
    private LocalDateTime lastTimeReviewed;
    private int hits;
    private boolean learned;
    private LocalDateTime learnedDate;
    @OneToOne(mappedBy = "wordProgress")
    private Word word;

    public WordProgress() {
    }

    public WordProgress(Long id, int timesReviewed, LocalDateTime lastTimeReviewed, int hits, boolean learned, LocalDateTime learnedDate, Word word) {
        this.id = id;
        this.timesReviewed = timesReviewed;
        this.lastTimeReviewed = lastTimeReviewed;
        this.hits = hits;
        this.learned = learned;
        this.learnedDate = learnedDate;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTimesReviewed() {
        return timesReviewed;
    }

    public void setTimesReviewed(int timesReviewed) {
        this.timesReviewed = timesReviewed;
    }

    public LocalDateTime getLastTimeReviewed() {
        return lastTimeReviewed;
    }

    public void setLastTimeReviewed(LocalDateTime lastTimeReviewed) {
        this.lastTimeReviewed = lastTimeReviewed;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public LocalDateTime getLearnedDate() {
        return learnedDate;
    }

    public void setLearnedDate(LocalDateTime learnedDate) {
        this.learnedDate = learnedDate;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
