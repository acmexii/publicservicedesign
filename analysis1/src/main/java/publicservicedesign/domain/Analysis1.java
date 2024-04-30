package publicservicedesign.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import publicservicedesign.Analysis1Application;

@Entity
@Table(name = "Analysis1_table")
@Data
// <<< DDD / Aggregate Root
public class Analysis1 {

    @Id
    private String complaintType;

    private Long totalCount;

    private Long approvedCount;

    private Long rejectedCount;

    public static Analysis1Repository repository() {
        Analysis1Repository analysis1Repository = Analysis1Application.applicationContext.getBean(
                Analysis1Repository.class);
        return analysis1Repository;
    }

    // <<< Clean Arch / Port Method
    public static void 데이터수집(InvestigationApproved investigationApproved) {

        데이터수집(true);

    }

    public static void 데이터수집(InvestigationDeleted investigationDeleted) {

        데이터수집(false);

    }

    public static void 데이터수집(boolean approved) {

        repository().findById("Type1").ifPresentOrElse(analysis1 -> {
            if (approved)
                analysis1.setApprovedCount(analysis1.getApprovedCount() + 1);
            else
                analysis1.setRejectedCount(analysis1.getRejectedCount() + 1);

            analysis1.setTotalCount(analysis1.getTotalCount() + 1);
        }, () -> {
            Analysis1 analysis1 = new Analysis1();
            analysis1.setApprovedCount(0L);
            analysis1.setRejectedCount(0L);
            analysis1.setTotalCount(0L);
            analysis1.setComplaintType("Type1");
            repository().save(analysis1);

        });

    }

}
// >>> DDD / Aggregate Root
