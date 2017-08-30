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

import cl.citiaps.spring.backend.entities.FilmActor;
import cl.citiaps.spring.backend.repository.FilmActorRepository;

@RestController  
@RequestMapping("/filmactors")
public class FilmActorService {
	
	@Autowired
	private FilmActorRepository filmActorRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<FilmActor> getAllFilmActors() {
		return filmActorRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  FilmActor findOne(@PathVariable("id") Integer id) {
		return filmActorRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public FilmActor create(@RequestBody FilmActor resource) {
	     return filmActorRepository.save(resource);
	}
	
}
	 
