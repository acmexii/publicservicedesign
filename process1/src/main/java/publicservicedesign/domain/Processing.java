package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import publicservicedesign.Process1Application;
import publicservicedesign.domain.ProcessingCreated;
import publicservicedesign.domain.ProcessingDeleted;

@Entity
@Table(name = "Processing_table")
@Data
//<<< DDD / Aggregate Root
public class Processing {

    @Id
    private String name;

    private Date date;

    private String 민원번호;

    @PostPersist
    public void onPostPersist() {
        ProcessingCreated processingCreated = new ProcessingCreated(this);
        processingCreated.publishAfterCommit();

        ProcessingDeleted processingDeleted = new ProcessingDeleted(this);
        processingDeleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProcessingRepository repository() {
        ProcessingRepository processingRepository = Process1Application.applicationContext.getBean(
            ProcessingRepository.class
        );
        return processingRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateProcessing(
        UpdateProcessingCommand updateProcessingCommand
    ) {
        //implement business logic here:

        ProcessingUpdated processingUpdated = new ProcessingUpdated(this);
        processingUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
