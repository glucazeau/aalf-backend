package fr.croixrouge.paris.aalf.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
