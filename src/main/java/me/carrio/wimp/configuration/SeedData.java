package me.carrio.wimp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import me.carrio.wimp.models.Actor;
import me.carrio.wimp.models.Movie;
import me.carrio.wimp.repositories.ActorRepository;
import me.carrio.wimp.repositories.MovieRepository;

@Configuration
@Profile("development")
public class SeedData {
	
	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo) {		
		actorRepo.save(new Actor("Mike", "Myers", (long) 1990, new java.sql.Date(1970, 1, 1)));
		actorRepo.save(new Actor("Chris", "Pratt", (long) 2003, new java.sql.Date(1985, 1, 1)));
		movieRepo.save(new Movie("Waynes World", null, (long) 250000, "Universal"));
		movieRepo.save(new Movie("Goldmember", null, (long) 1500000, "Universal"));
	}
	
}