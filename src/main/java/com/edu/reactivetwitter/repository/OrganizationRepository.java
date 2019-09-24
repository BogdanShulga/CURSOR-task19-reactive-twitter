package com.edu.reactivetwitter.repository;

import com.edu.reactivetwitter.model.Organization;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Extending from <code>ReactiveCrudRepository</code> adds reactive methods. Only supported for:
 *
 * - MongoDB
 * - Couchbase
 * - Cassandra
 * - Redis
 */
public interface OrganizationRepository extends ReactiveCrudRepository<Organization, String> {
}
