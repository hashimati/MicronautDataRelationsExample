package io.hashimati.databaseexamples.repositories;

import java.util.List;
import java.util.Optional;

import io.hashimati.databaseexamples.domains.Person;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * PersonRepository
 */

@Repository
@Join("addresses")
public interface PersonRepository extends CrudRepository<Person, Long> {
    public List<Person> findByName(String name);
    public Optional<Person> findById(long i);
    public List<Person> findAll(); 
}