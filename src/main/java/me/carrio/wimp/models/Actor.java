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
@Table(name="actors")
public class Actor {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="firstName", nullable=false, length=75)
	private String firstName;
	
	@Column(name="lastName", nullable=true, length=75)
	private String lastName;
	
	@Column(name="activeSinceYear", nullable=false)
	private Long activeSinceYear;
	
	@Column(name="birthDate", nullable=false)
	private Date birthDate;
	
	@ManyToMany(mappedBy="actors")
	private List<Movie> movies;
	
	public Actor() {}
	
	public Actor(String f, String l, Long y, Date b) {
		this.firstName = f;
		this.lastName = l;
		this.activeSinceYear = y;
		this.birthDate = b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getActiveSinceYear() {
		return activeSinceYear;
	}

	public void setActiveSinceYear(Long activeSinceYear) {
		this.activeSinceYear = activeSinceYear;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
