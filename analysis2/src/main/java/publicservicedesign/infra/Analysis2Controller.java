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
// @RequestMapping(value="/analysis2s")
@Transactional
public class Analysis2Controller {

    @Resource(name = "analysis2Service")
    private Analysis2Service analysis2Service;

    @GetMapping("/analysis2")
    public List<Analysis2> getAllAnalysis2s() throws Exception {
        // Get all analysis2s via Analysis2Service
        return analysis2Service.getAllAnalysis2s();
    }

    @GetMapping("/analysis2/{id}")
    public Optional<Analysis2> getAnalysis2ById(@PathVariable Long id)
        throws Exception {
        // Get a analysis2 by ID via Analysis2Service
        return analysis2Service.getAnalysis2ById(id);
    }

    @PostMapping("/analysis2")
    public Analysis2 createAnalysis2(@RequestBody Analysis2 analysis2)
        throws Exception {
        // Create a new analysis2 via Analysis2Service
        return analysis2Service.createAnalysis2(analysis2);
    }

    @PutMapping("/analysis2/{id}")
    public Analysis2 updateAnalysis2(
        @PathVariable Long id,
        @RequestBody Analysis2 analysis2
    ) throws Exception {
        // Update an existing analysis2 via Analysis2Service
        return analysis2Service.updateAnalysis2(analysis2);
    }

    @DeleteMapping("/analysis2/{id}")
    public void deleteAnalysis2(@PathVariable Long id) throws Exception {
        // Delete a analysis2 via Analysis2Service
        analysis2Service.deleteAnalysis2(id);
    }
}
