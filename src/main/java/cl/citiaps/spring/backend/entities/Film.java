package cl.citiaps.spring.backend.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(name="title", nullable=false, length=45)
	private String title;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

//	@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"))
	@ManyToMany(mappedBy="films")
	private List<Actor> actors;
	
	public Film() {
	}
	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
//	public List<Actor> getActors()
//	{
//		return actors;
//	}
	
//	public List<Actor> getActors() {
//        return this.actors;
//    }
	@JsonIgnore
	public List<Actor> getActors()
	{
		return actors;
	}

}