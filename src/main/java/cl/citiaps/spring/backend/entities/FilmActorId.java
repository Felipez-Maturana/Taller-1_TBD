package cl.citiaps.spring.backend.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class FilmActorId implements java.io.Serializable {

	private Actor actor;
    private Film film;

	@ManyToOne
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@ManyToOne
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}