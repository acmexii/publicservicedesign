package publicservicedesign.service;

import java.util.List;
import java.util.Optional;
import publicservicedesign.domain.*;

public interface CompensationPaymentService {
    List<CompensationPayment> getAllCompensationPayments() throws Exception;
    Optional<CompensationPayment> getCompensationPaymentById(String id)
        throws Exception;
    CompensationPayment createCompensationPayment(
        CompensationPayment compensationPayment
    ) throws Exception;
    CompensationPayment updateCompensationPayment(
        CompensationPayment compensationPayment
    ) throws Exception;
    void deleteCompensationPayment(String id) throws Exception;
}
