package cl.citiaps.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.entities.Actor;
import java.util.List;


public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {
	

}
