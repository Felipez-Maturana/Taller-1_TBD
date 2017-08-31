package cl.citiaps.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.repository.ActorRepository;
import cl.citiaps.spring.backend.repository.FilmRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;


@RestController  
@RequestMapping("/actors")
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private FilmRepository filmRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Actor> getAllUsers() {
		return actorRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  Actor findOne(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Actor create(@RequestBody Actor resource) {
	     return actorRepository.save(resource);
	}
	
//	@RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
//	@ResponseBody
//	public  List<Actor> findTwo(@PathVariable("id") Integer id) {
//		return actorRepository.findMoviesActor(id);
//	}

//	@RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
//	@ResponseBody
//	public Set<Film> findTwo(@PathVariable("id") Integer id) {
//		Actor actor = actorRepository.findOne(id);		
//		
//		return actor.getFilms();
//	}
	@RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
	@ResponseBody
	public List<Film> findActorMovies(@PathVariable("id") Integer id) {
	
		Actor actor = actorRepository.findOne(id);
		
		return actor.getFilms();
	}
	
	@RequestMapping(value = "/{actor_id}/films/{id}",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Actor createActorMovie(@PathVariable("id") Integer id, @PathVariable("actor_id") Integer actor_id) {
		Film film = filmRepository.findOne(id); 
		if(film!=null)
		{
			Actor actor = actorRepository.findOne(actor_id);
			actor.getFilms().add(film);
		    actorRepository.save(actor);
		    return actor;
		}
		else
		{
			return null;
		}

	}
	
	
	 
}