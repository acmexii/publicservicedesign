package publicservicedesign.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import publicservicedesign.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "compensationPayments",
    path = "compensationPayments"
)
public interface CompensationPaymentRepository
    extends PagingAndSortingRepository<CompensationPayment, String> {}
