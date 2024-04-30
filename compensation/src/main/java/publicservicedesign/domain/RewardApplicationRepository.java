package publicservicedesign.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import publicservicedesign.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "rewardApplications",
    path = "rewardApplications"
)
public interface RewardApplicationRepository
    extends PagingAndSortingRepository<RewardApplication, String> {}
