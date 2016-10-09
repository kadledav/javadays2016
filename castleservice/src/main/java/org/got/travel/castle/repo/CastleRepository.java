package org.got.travel.castle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.got.travel.castle.model.Castle;

/**
 * Castle Repository interface defines operations to
 * access and manipulate castles. It uses the Spring Data
 * feature by extension from the JpaRepository interface.
 * The JpaRepository supports pagination and sorting.
 *
 * The Spring's REST Repository feature can be used to directly expose
 * a Repository as Hypermedia REST API.
 *  - http://projects.spring.io/spring-data-rest/
 *  - https://en.wikipedia.org/wiki/HATEOAS
 *
 *
 * @author macalak@itexperts.sk
 *
 */

@Repository
public interface CastleRepository extends JpaRepository<Castle,Long> {

}
