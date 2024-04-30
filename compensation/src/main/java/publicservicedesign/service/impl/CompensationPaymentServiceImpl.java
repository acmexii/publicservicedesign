package publicservicedesign.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import publicservicedesign.domain.CompensationPayment;
import publicservicedesign.domain.CompensationPaymentRepository;
import publicservicedesign.service.CompensationPaymentService;

@Service("compensationPaymentService")
@Transactional
public class CompensationPaymentServiceImpl
    extends EgovAbstractServiceImpl
    implements CompensationPaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        CompensationPaymentServiceImpl.class
    );

    @Autowired
    CompensationPaymentRepository compensationPaymentRepository;

    @Override
    public List<CompensationPayment> getAllCompensationPayments()
        throws Exception {
        // Get all compensationPayments
        return StreamSupport
            .stream(
                compensationPaymentRepository.findAll().spliterator(),
                false
            )
            .collect(Collectors.toList());
    }

    @Override
    public Optional<CompensationPayment> getCompensationPaymentById(String id)
        throws Exception {
        // Get a compensationPayment by ID
        return compensationPaymentRepository.findById(id);
    }

    @Override
    public CompensationPayment createCompensationPayment(
        CompensationPayment compensationPayment
    ) throws Exception {
        // Create a new compensationPayment
        return compensationPaymentRepository.save(compensationPayment);
    }

    @Override
    public CompensationPayment updateCompensationPayment(
        CompensationPayment compensationPayment
    ) throws Exception {
        // Update an existing compensationPayment via CompensationPaymentService
        if (
            compensationPaymentRepository.existsById(
                compensationPayment.getId()
            )
        ) {
            return compensationPaymentRepository.save(compensationPayment);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteCompensationPayment(String id) throws Exception {
        // Delete a compensationPayment
        compensationPaymentRepository.deleteById(id);
    }
}
