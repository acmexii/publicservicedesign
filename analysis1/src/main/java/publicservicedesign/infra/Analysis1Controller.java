package publicservicedesign.infra;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import publicservicedesign.domain.Analysis1;
import publicservicedesign.service.Analysis1Service;

@RestController
// @RequestMapping(value="/analysis1s")
@Transactional
public class Analysis1Controller {

    @Resource(name = "analysis1Service")
    private Analysis1Service analysis1Service;

    @GetMapping("/analysis1")
    public List<Analysis1> getAllAnalysis1s() throws Exception {
        // Get all analysis1s via Analysis1Service
        return analysis1Service.getAllAnalysis1s();
    }

    @GetMapping("/analysis1/{id}")
    public Optional<Analysis1> getAnalysis1ById(
            @PathVariable String complaintType) throws Exception {
        // Get a analysis1 by ID via Analysis1Service
        return analysis1Service.getAnalysis1ById(complaintType);
    }

    @PostMapping("/analysis1")
    public Analysis1 createAnalysis1(@RequestBody Analysis1 analysis1)
            throws Exception {
        // Create a new analysis1 via Analysis1Service
        return analysis1Service.createAnalysis1(analysis1);
    }

    @PutMapping("/analysis1/{id}")
    public Analysis1 updateAnalysis1(
            @PathVariable String complaintType,
            @RequestBody Analysis1 analysis1) throws Exception {
        // Update an existing analysis1 via Analysis1Service
        return analysis1Service.updateAnalysis1(analysis1);
    }

    @DeleteMapping("/analysis1/{id}")
    public void deleteAnalysis1(@PathVariable String complaintType)
            throws Exception {
        // Delete a analysis1 via Analysis1Service
        analysis1Service.deleteAnalysis1(complaintType);
    }
}
