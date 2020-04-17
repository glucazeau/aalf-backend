package fr.croixrouge.paris.aalf.role;

import fr.croixrouge.paris.aalf.user.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface RoleRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByEmailAddress(final String emailAddress);
}
