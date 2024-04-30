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
import publicservicedesign.domain.RewardApplication;
import publicservicedesign.domain.RewardApplicationRepository;
import publicservicedesign.domain.UpdateCompensationReviewStatusCommand;
import publicservicedesign.service.RewardApplicationService;

@Service("rewardApplicationService")
@Transactional
public class RewardApplicationServiceImpl
    extends EgovAbstractServiceImpl
    implements RewardApplicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        RewardApplicationServiceImpl.class
    );

    @Autowired
    RewardApplicationRepository rewardApplicationRepository;

    @Override
    public List<RewardApplication> getAllRewardApplications() throws Exception {
        // Get all rewardApplications
        return StreamSupport
            .stream(rewardApplicationRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<RewardApplication> getRewardApplicationById(String id)
        throws Exception {
        // Get a rewardApplication by ID
        return rewardApplicationRepository.findById(id);
    }

    @Override
    public RewardApplication createRewardApplication(
        RewardApplication rewardApplication
    ) throws Exception {
        // Create a new rewardApplication
        return rewardApplicationRepository.save(rewardApplication);
    }

    @Override
    public RewardApplication updateRewardApplication(
        RewardApplication rewardApplication
    ) throws Exception {
        // Update an existing rewardApplication via RewardApplicationService
        if (rewardApplicationRepository.existsById(rewardApplication.getId())) {
            return rewardApplicationRepository.save(rewardApplication);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteRewardApplication(String id) throws Exception {
        // Delete a rewardApplication
        rewardApplicationRepository.deleteById(id);
    }

    @Override
    public RewardApplication updateCompensationReviewStatus(
        UpdateCompensationReviewStatusCommand updateCompensationReviewStatusCommand
    ) throws Exception {
        // You can implement logic here, or call the domain method of the RewardApplication.

        /** Choice 1:  implement logic here        
        Optional<RewardApplication> optionalRewardApplication = rewardApplicationRepository.findById(updateCompensationReviewStatusCommand.getRewardApplicationId());

        if (optionalRewardApplication.isPresent()) {
            RewardApplication rewardApplication = optionalRewardApplication.get();
            
            // business Logic....
            rewardApplicationRepository.save(rewardApplication);

            return rewardApplication;
        } else {
            throw processException("info.nodata.msg");
        }
       

        /** Choice 2:  call the domain method of the RewardApplication.   
        return RewardApplication.updateCompensationReviewStatus(updateCompensationReviewStatusCommand);
           */
        return null;
    }
}
