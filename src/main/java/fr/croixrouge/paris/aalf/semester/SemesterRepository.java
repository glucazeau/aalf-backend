package fr.croixrouge.paris.aalf.semester;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "semesters", path = "semesters")
public interface SemesterRepository extends CrudRepository<Semester, Integer> {}
