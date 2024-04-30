package publicservicedesign.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import publicservicedesign.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "processings",
    path = "processings"
)
public interface ProcessingRepository
    extends PagingAndSortingRepository<Processing, String> {}
