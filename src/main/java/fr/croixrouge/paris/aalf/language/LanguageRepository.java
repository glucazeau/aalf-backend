package fr.croixrouge.paris.aalf.language;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LanguageRepository extends CrudRepository<Language, Integer> {}
