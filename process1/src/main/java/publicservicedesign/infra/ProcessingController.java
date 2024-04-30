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
// @RequestMapping(value="/processings")
@Transactional
public class ProcessingController {

    @Resource(name = "processingService")
    private ProcessingService processingService;

    @GetMapping("/processing")
    public List<Processing> getAllProcessings() throws Exception {
        // Get all processings via ProcessingService
        return processingService.getAllProcessings();
    }

    @GetMapping("/processing/{id}")
    public Optional<Processing> getProcessingById(@PathVariable String name)
        throws Exception {
        // Get a processing by ID via ProcessingService
        return processingService.getProcessingById(name);
    }

    @PostMapping("/processing")
    public Processing createProcessing(@RequestBody Processing processing)
        throws Exception {
        // Create a new processing via ProcessingService
        return processingService.createProcessing(processing);
    }

    @PutMapping("/processing/{id}")
    public Processing updateProcessing(
        @PathVariable String name,
        @RequestBody Processing processing
    ) throws Exception {
        // Update an existing processing via ProcessingService
        return processingService.updateProcessing(processing);
    }

    @DeleteMapping("/processing/{id}")
    public void deleteProcessing(@PathVariable String name) throws Exception {
        // Delete a processing via ProcessingService
        processingService.deleteProcessing(name);
    }

    @RequestMapping(
        value = "processing/{id}//process",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Processing updateProcessing(
        @PathVariable(value = "id") String name,
        @RequestBody UpdateProcessingCommand updateProcessingCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return processingService.updateProcessing(updateProcessingCommand);
    }
}
