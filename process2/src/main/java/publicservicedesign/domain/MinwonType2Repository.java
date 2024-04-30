package publicservicedesign.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import publicservicedesign.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "minwonType2s",
    path = "minwonType2s"
)
public interface MinwonType2Repository
    extends PagingAndSortingRepository<MinwonType2, String> {}
