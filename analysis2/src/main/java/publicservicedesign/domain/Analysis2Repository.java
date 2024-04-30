package publicservicedesign.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import publicservicedesign.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "analysis2s",
    path = "analysis2s"
)
public interface Analysis2Repository
    extends PagingAndSortingRepository<Analysis2, Long> {}
