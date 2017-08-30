package cl.citiaps.spring.backend.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "film_actor")
@AssociationOverrides({
	@AssociationOverride(name = "pk.actor",
		joinColumns = @JoinColumn(name = "ACTOR_ID")),
	@AssociationOverride(name = "pk.film",
		joinColumns = @JoinColumn(name = "FILM_ID")) })

public class FilmActor implements java.io.Serializable {

	private FilmActorId pk = new FilmActorId();
	
	public FilmActor() {
	}
	
	@EmbeddedId
	public FilmActorId getPk() {
		return pk;
	}

	public void setPk(FilmActorId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Actor getActor() {
		return getPk().getActor();
	}

	public void setActor(Actor actor) {
		getPk().setActor(actor);
	}
	
	@Transient
	public Film getFilm() {
		return getPk().getFilm();
	}

	public void setFilm(Film film) {
		getPk().setFilm(film);
	}
}
