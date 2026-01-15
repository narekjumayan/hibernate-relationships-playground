package com.narek.movieclubapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "reviews")
public class Review {
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", nullable = false)
    Movie movie;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int rating;
    private String comment;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", movie=" + movie +
                ", user=" + user +
                '}';
    }
}
