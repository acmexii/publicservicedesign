package publicservicedesign.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import publicservicedesign.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "investigations",
    path = "investigations"
)
public interface InvestigationRepository
    extends PagingAndSortingRepository<Investigation, String> {}
