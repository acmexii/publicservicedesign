package publicservicedesign.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import publicservicedesign.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "applications",
    path = "applications"
)
public interface ApplicationRepository
    extends PagingAndSortingRepository<Application, String> {}
