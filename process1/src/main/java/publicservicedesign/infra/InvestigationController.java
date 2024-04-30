package publicservicedesign.infra;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import publicservicedesign.domain.Investigation;
import publicservicedesign.domain.UpdateInvestigationCommand;
import publicservicedesign.service.InvestigationService;

@RestController
// @RequestMapping(value="/investigations")
@Transactional
public class InvestigationController {

    @Resource(name = "investigationService")
    private InvestigationService investigationService;

    @GetMapping("/investigation")
    public List<Investigation> getAllInvestigations() throws Exception {
        // Get all investigations via InvestigationService
        return investigationService.getAllInvestigations();
    }

    @GetMapping("/investigation/{id}")
    public Optional<Investigation> getInvestigationById(
            @PathVariable String name) throws Exception {
        // Get a investigation by ID via InvestigationService
        return investigationService.getInvestigationById(name);
    }

    @PostMapping("/investigation")
    public Investigation createInvestigation(
            @RequestBody Investigation investigation) throws Exception {
        // Create a new investigation via InvestigationService
        return investigationService.createInvestigation(investigation);
    }

    @PutMapping("/investigation/{id}")
    public Investigation updateInvestigation(
            @PathVariable String name,
            @RequestBody Investigation investigation) throws Exception {
        // Update an existing investigation via InvestigationService
        return investigationService.updateInvestigation(investigation);
    }

    @DeleteMapping("/investigation/{id}")
    public void deleteInvestigation(@PathVariable String name)
            throws Exception {
        // Delete a investigation via InvestigationService
        investigationService.deleteInvestigation(name);
    }

    @RequestMapping(value = "investigations/{id}/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public Investigation updateInvestigation(
            @PathVariable(value = "id") String id,
            @RequestBody UpdateInvestigationCommand updateInvestigationCommand,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        updateInvestigationCommand.setInvestigationId(id);
        return investigationService.updateInvestigation(
                updateInvestigationCommand);
    }
}
