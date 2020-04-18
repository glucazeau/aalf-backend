package fr.croixrouge.paris.aalf.organization_branch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "organizationBranches", path = "organizationBranches")
public interface OrganizationBranchRepository extends CrudRepository<OrganizationBranch, Integer> {
}
