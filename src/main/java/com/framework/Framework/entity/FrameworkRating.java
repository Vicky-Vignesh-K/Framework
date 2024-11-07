package com.framework.Framework.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "framework_rating")
public class FrameworkRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "framework_rating_id")
    private Long frameworkRatingId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private FrameworkVersion frameworkVersion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Rating rating;

    @Column(name = "framework_rating_score")
    private Double frameworkRatingScore;


    public Long getFrameworkRatingId() {
        return frameworkRatingId;
    }

    public void setFrameworkRatingId(Long frameworkRatingId) {
        this.frameworkRatingId = frameworkRatingId;
    }

    public FrameworkVersion getFrameworkVersion() {
        return frameworkVersion;
    }

    public void setFrameworkVersion(FrameworkVersion frameworkVersion) {
        this.frameworkVersion = frameworkVersion;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Double getFrameworkRatingScore() {
        return frameworkRatingScore;
    }

    public void setFrameworkRatingScore(Double frameworkRatingScore) {
        this.frameworkRatingScore = frameworkRatingScore;
    }
}
