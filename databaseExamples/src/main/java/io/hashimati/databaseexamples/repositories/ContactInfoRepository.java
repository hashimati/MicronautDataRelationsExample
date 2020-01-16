package io.hashimati.databaseexamples.repositories;

import io.hashimati.databaseexamples.domains.ContactInfo;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * ContactInfoRepository
 */

@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {
}