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
// @RequestMapping(value="/rewardApplications")
@Transactional
public class RewardApplicationController {

    @Resource(name = "rewardApplicationService")
    private RewardApplicationService rewardApplicationService;

    @GetMapping("/rewardApplication")
    public List<RewardApplication> getAllRewardApplications() throws Exception {
        // Get all rewardApplications via RewardApplicationService
        return rewardApplicationService.getAllRewardApplications();
    }

    @GetMapping("/rewardApplication/{id}")
    public Optional<RewardApplication> getRewardApplicationById(
        @PathVariable String id
    ) throws Exception {
        // Get a rewardApplication by ID via RewardApplicationService
        return rewardApplicationService.getRewardApplicationById(id);
    }

    @PostMapping("/rewardApplication")
    public RewardApplication createRewardApplication(
        @RequestBody RewardApplication rewardApplication
    ) throws Exception {
        // Create a new rewardApplication via RewardApplicationService
        return rewardApplicationService.createRewardApplication(
            rewardApplication
        );
    }

    @PutMapping("/rewardApplication/{id}")
    public RewardApplication updateRewardApplication(
        @PathVariable String id,
        @RequestBody RewardApplication rewardApplication
    ) throws Exception {
        // Update an existing rewardApplication via RewardApplicationService
        return rewardApplicationService.updateRewardApplication(
            rewardApplication
        );
    }

    @DeleteMapping("/rewardApplication/{id}")
    public void deleteRewardApplication(@PathVariable String id)
        throws Exception {
        // Delete a rewardApplication via RewardApplicationService
        rewardApplicationService.deleteRewardApplication(id);
    }

    @RequestMapping(
        value = "rewardApplication/{id}/status",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public RewardApplication updateCompensationReviewStatus(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateCompensationReviewStatusCommand updateCompensationReviewStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return rewardApplicationService.updateCompensationReviewStatus(
            updateCompensationReviewStatusCommand
        );
    }
}
