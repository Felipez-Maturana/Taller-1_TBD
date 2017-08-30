package cl.citiaps.spring.backend.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the film_actor database table.
 * 
 */
@Entity
@Table(name="film_actor")
@NamedQuery(name="FilmActor.findAll", query="SELECT a FROM FilmActor a")
public class FilmActor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="film_actor_id", unique=true, nullable=false)
	private int film_actorId;
	
	@Column(name="actor_id", nullable=false)
	private int actorId;

	@Column(name="film_id", nullable=false)
	private int filmId;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	public FilmActor() {
	}
	
	public int getFilmActorId() {
		return this.film_actorId;
	}

	public void getFilmActorId(int film_actorId) {
		this.film_actorId = film_actorId;
	}
	
	public int getFilmId() {
		return this.filmId;
	}

	public void getFilmId(int filmId) {
		this.filmId = filmId;
	}
	
	public int getActorId() {
		return this.actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}