package me.carrio.wimp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.carrio.wimp.models.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
