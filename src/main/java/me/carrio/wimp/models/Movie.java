package me.carrio.wimp.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="movies")
public class Movie {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="title", length=300, nullable=false)
	private String title;
	
	@Column(name="releaseDate", nullable=true)
	private Date releaseDate;
	
	@Column(name="budget", nullable=true)
	private Long budget;
	
	@Column(name="distributor", nullable=false, length=500)
	private String distributor;
	
	@ManyToMany
	private List<Actor> actors;
	
	public Movie() {}
	
	public Movie(String t, Date r, Long b, String d) {
		this.title = t;
		this.releaseDate = r;
		this.budget = b;
		this.distributor = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	
}
