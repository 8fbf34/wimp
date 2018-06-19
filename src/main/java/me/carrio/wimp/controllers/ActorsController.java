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
import me.carrio.wimp.repositories.ActorRepository;

@RestController
@RequestMapping("/api/actors")
public class ActorsController {
	
	@Autowired
	private ActorRepository repo;

	public ActorsController(ActorRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("")
	public List<Actor> getAll() {
		System.out.println("Received GET");
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	public Actor getOne(@PathVariable int id) {
		Optional<Actor> m = repo.findById(id);
		if(m.isPresent()) {
			return m.get();
		}
		return null;
	}
	
	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return repo.save(actor);
	}
	
	@PutMapping("{id}")
	public Actor update(@PathVariable int id) {
		Optional<Actor> m = repo.findById(id);
		if(m.isPresent()) {
			return m.get();
		}
		return null;
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		repo.deleteById(id);
	}
}
