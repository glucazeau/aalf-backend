package fr.croixrouge.paris.aalf.classlevel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
  collectionResourceRel = "classlevels",
  path = "classlevels"
)
public interface ClassLevelRepository
  extends CrudRepository<ClassLevel, Integer> {}
