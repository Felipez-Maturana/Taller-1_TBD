package cl.citiaps.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Actor;

import java.util.List;

import org.hibernate.Query;

import java.util.Optional;

public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
	

}
