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
// @RequestMapping(value="/applications")
@Transactional
public class ApplicationController {

    @Resource(name = "applicationService")
    private ApplicationService applicationService;

    @GetMapping("/application")
    public List<Application> getAllApplications() throws Exception {
        // Get all applications via ApplicationService
        return applicationService.getAllApplications();
    }

    @GetMapping("/application/{id}")
    public Optional<Application> getApplicationById(
        @PathVariable String 민원번호
    ) throws Exception {
        // Get a application by ID via ApplicationService
        return applicationService.getApplicationById(민원번호);
    }

    @PostMapping("/application")
    public Application createApplication(@RequestBody Application application)
        throws Exception {
        // Create a new application via ApplicationService
        return applicationService.createApplication(application);
    }

    @PutMapping("/application/{id}")
    public Application updateApplication(
        @PathVariable String 민원번호,
        @RequestBody Application application
    ) throws Exception {
        // Update an existing application via ApplicationService
        return applicationService.updateApplication(application);
    }

    @DeleteMapping("/application/{id}")
    public void deleteApplication(@PathVariable String 민원번호)
        throws Exception {
        // Delete a application via ApplicationService
        applicationService.deleteApplication(민원번호);
    }
}
