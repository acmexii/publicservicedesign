package publicservicedesign.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import publicservicedesign.Process1Application;

@Entity
@Table(name = "Investigation_table")
@Data
// <<< DDD / Aggregate Root
public class Investigation {

    @Id
    private String name;

    private String description;

    private Date date;

    private String 민원번호;

    private String status;

    @PostPersist
    public void onPostPersist() {
        InvestigationCreated investigationCreated = new InvestigationCreated(
                this);
        investigationCreated.publishAfterCommit();

    }

    @PrePersist
    public void onPrePersist() {
    }

    public static InvestigationRepository repository() {
        InvestigationRepository investigationRepository = Process1Application.applicationContext.getBean(
                InvestigationRepository.class);
        return investigationRepository;
    }

    // <<< Clean Arch / Port Method
    public void updateInvestigation(
            UpdateInvestigationCommand updateInvestigationCommand) {
        // implement business logic here:
        if (updateInvestigationCommand.getApprove()) {

            InvestigationApproved investigationApproved = new InvestigationApproved(
                    this);
            investigationApproved.publishAfterCommit();

        } else {
            InvestigationDeleted investigationDeleted = new InvestigationDeleted(this);
            investigationDeleted.publishAfterCommit();
        }

    }
    // >>> Clean Arch / Port Method

}
// >>> DDD / Aggregate Root
