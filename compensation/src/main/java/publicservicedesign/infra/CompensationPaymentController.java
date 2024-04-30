package publicservicedesign.infra;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publicservicedesign.domain.*;
import publicservicedesign.service.*;

@RestController
// @RequestMapping(value="/compensationPayments")
@Transactional
public class CompensationPaymentController {

    @Resource(name = "compensationPaymentService")
    private CompensationPaymentService compensationPaymentService;

    @GetMapping("/compensationPayment")
    public List<CompensationPayment> getAllCompensationPayments()
        throws Exception {
        // Get all compensationPayments via CompensationPaymentService
        return compensationPaymentService.getAllCompensationPayments();
    }

    @GetMapping("/compensationPayment/{id}")
    public Optional<CompensationPayment> getCompensationPaymentById(
        @PathVariable String id
    ) throws Exception {
        // Get a compensationPayment by ID via CompensationPaymentService
        return compensationPaymentService.getCompensationPaymentById(id);
    }

    @PostMapping("/compensationPayment")
    public CompensationPayment createCompensationPayment(
        @RequestBody CompensationPayment compensationPayment
    ) throws Exception {
        // Create a new compensationPayment via CompensationPaymentService
        return compensationPaymentService.createCompensationPayment(
            compensationPayment
        );
    }

    @PutMapping("/compensationPayment/{id}")
    public CompensationPayment updateCompensationPayment(
        @PathVariable String id,
        @RequestBody CompensationPayment compensationPayment
    ) throws Exception {
        // Update an existing compensationPayment via CompensationPaymentService
        return compensationPaymentService.updateCompensationPayment(
            compensationPayment
        );
    }

    @DeleteMapping("/compensationPayment/{id}")
    public void deleteCompensationPayment(@PathVariable String id)
        throws Exception {
        // Delete a compensationPayment via CompensationPaymentService
        compensationPaymentService.deleteCompensationPayment(id);
    }
}
