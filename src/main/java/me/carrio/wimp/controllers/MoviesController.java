package me.carrio.wimp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.carrio.wimp.models.Actor;
import me.carrio.wimp.models.IdBody;
import me.carrio.wimp.models.Movie;
import me.carrio.wimp.repositories.ActorRepository;
import me.carrio.wimp.repositories.MovieRepository;


@RestController
@RequestMapping("/api/movies")
public class MoviesController {

	@Autowired
	private MovieRepository repo;
	@Autowired
	private ActorRepository actorRepo;
	
	
	public MoviesController(MovieRepository repo, ActorRepository aRepo) {
		this.repo = repo;
		this.actorRepo = aRepo;
	}
	
	@GetMapping("")
	public List<Movie> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	public Movie getOne(@PathVariable int id) {
		Optional<Movie> m = repo.findById(id);
		return m.isPresent() ? m.get(): null;
	}
	
	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		return repo.save(movie);
	}
	
	@PutMapping("{id}")
	public Movie update(@PathVariable int id) {
		Optional<Movie> m = repo.findById(id);
		return m.isPresent() ? m.get() : null;
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		repo.deleteById(id);
	}

	@PostMapping("{movieId}/actors")
	public Movie addActorToMovie(@PathVariable int movieId, @RequestBody IdBody body) {
		Movie movie;
		Actor actor;
		Optional<Movie> m = repo.findById(movieId);
		if(!m.isPresent()) {
			return null;
		}
		movie = m.get();
		Optional<Actor> a = actorRepo.findById(body.getId());
		if(!a.isPresent()) {
			return null;
		}
		actor = a.get();
		if(!movie.getActors().contains(actor)) {
			movie.getActors().add(actor);
			repo.save(movie);
		}
		return movie;
	}
	
}
