package io.hashimati.databaseexamples.repositories;

import io.hashimati.databaseexamples.domains.Address;
import io.hashimati.databaseexamples.domains.ContactInfo;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * AddressRepository
 */

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}