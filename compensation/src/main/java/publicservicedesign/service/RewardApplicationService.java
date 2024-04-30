package publicservicedesign.service;

import java.util.List;
import java.util.Optional;
import publicservicedesign.domain.*;

public interface RewardApplicationService {
    List<RewardApplication> getAllRewardApplications() throws Exception;
    Optional<RewardApplication> getRewardApplicationById(String id)
        throws Exception;
    RewardApplication createRewardApplication(
        RewardApplication rewardApplication
    ) throws Exception;
    RewardApplication updateRewardApplication(
        RewardApplication rewardApplication
    ) throws Exception;
    void deleteRewardApplication(String id) throws Exception;

    RewardApplication updateCompensationReviewStatus(
        UpdateCompensationReviewStatusCommand updateCompensationReviewStatusCommand
    ) throws Exception;
}
