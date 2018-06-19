package me.carrio.wimp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.carrio.wimp.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
