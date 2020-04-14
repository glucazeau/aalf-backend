package fr.croixrouge.paris.aalf.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByEmailAddress(final String emailAddress);
}
