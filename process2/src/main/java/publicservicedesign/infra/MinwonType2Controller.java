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
// @RequestMapping(value="/minwonType2s")
@Transactional
public class MinwonType2Controller {

    @Resource(name = "minwonType2Service")
    private MinwonType2Service minwonType2Service;

    @GetMapping("/minwonType2")
    public List<MinwonType2> getAllMinwonType2s() throws Exception {
        // Get all minwonType2s via MinwonType2Service
        return minwonType2Service.getAllMinwonType2s();
    }

    @GetMapping("/minwonType2/{id}")
    public Optional<MinwonType2> getMinwonType2ById(@PathVariable String name)
        throws Exception {
        // Get a minwonType2 by ID via MinwonType2Service
        return minwonType2Service.getMinwonType2ById(name);
    }

    @PostMapping("/minwonType2")
    public MinwonType2 createMinwonType2(@RequestBody MinwonType2 minwonType2)
        throws Exception {
        // Create a new minwonType2 via MinwonType2Service
        return minwonType2Service.createMinwonType2(minwonType2);
    }

    @PutMapping("/minwonType2/{id}")
    public MinwonType2 updateMinwonType2(
        @PathVariable String name,
        @RequestBody MinwonType2 minwonType2
    ) throws Exception {
        // Update an existing minwonType2 via MinwonType2Service
        return minwonType2Service.updateMinwonType2(minwonType2);
    }

    @DeleteMapping("/minwonType2/{id}")
    public void deleteMinwonType2(@PathVariable String name) throws Exception {
        // Delete a minwonType2 via MinwonType2Service
        minwonType2Service.deleteMinwonType2(name);
    }

    @RequestMapping(
        value = "minwonType2/{id}/process",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public MinwonType2 updateMinwonType2(
        @PathVariable(value = "id") String name,
        @RequestBody UpdateMinwonType2Command updateMinwonType2Command,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return minwonType2Service.updateMinwonType2(updateMinwonType2Command);
    }
}
