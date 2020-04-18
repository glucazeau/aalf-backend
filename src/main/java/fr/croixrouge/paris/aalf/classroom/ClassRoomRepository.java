package fr.croixrouge.paris.aalf.classroom;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Integer> {
}
