package fr.croixrouge.paris.aalf.registration_slot;

import fr.croixrouge.paris.aalf.organization_branch.OrganizationBranch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
  collectionResourceRel = "registrationSlots",
  path = "registrationSlots"
)
public interface RegistrationSlotRepository
  extends CrudRepository<OrganizationBranch, Integer> {}
