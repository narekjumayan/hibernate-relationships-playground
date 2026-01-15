package com.narek.movieclubapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true)
    private String email;


    @OneToOne(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "club_members", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "club_id"))
    private Set<Club> clubs = new HashSet<>();

    public void setUserProfile(UserProfile profile) {
        if (this.userProfile != null) {
            this.userProfile.setUser(null);
        }
        this.userProfile = profile;
        if (profile != null) profile.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
