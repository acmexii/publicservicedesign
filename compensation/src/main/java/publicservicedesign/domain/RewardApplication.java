package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import publicservicedesign.CompensationApplication;
import publicservicedesign.domain.RewardApplicationCreated;

@Entity
@Table(name = "RewardApplication_table")
@Data
//<<< DDD / Aggregate Root
public class RewardApplication {

    @Id
    private String id;

    private String reason;

    @PostPersist
    public void onPostPersist() {
        RewardApplicationCreated rewardApplicationCreated = new RewardApplicationCreated(
            this
        );
        rewardApplicationCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static RewardApplicationRepository repository() {
        RewardApplicationRepository rewardApplicationRepository = CompensationApplication.applicationContext.getBean(
            RewardApplicationRepository.class
        );
        return rewardApplicationRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateCompensationReviewStatus(
        UpdateCompensationReviewStatusCommand updateCompensationReviewStatusCommand
    ) {
        //implement business logic here:

        CompensationApproved compensationApproved = new CompensationApproved(
            this
        );
        compensationApproved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
