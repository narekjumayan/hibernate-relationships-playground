package com.narek.movieclubapi.repositories;

import com.narek.movieclubapi.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club,Long> {

}
