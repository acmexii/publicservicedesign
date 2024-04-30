package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import publicservicedesign.Process2Application;
import publicservicedesign.domain.MinwonType2Created;
import publicservicedesign.domain.MinwonType2Deleted;

@Entity
@Table(name = "MinwonType2_table")
@Data
//<<< DDD / Aggregate Root
public class MinwonType2 {

    @Id
    private String name;

    private String description;

    @PostPersist
    public void onPostPersist() {
        MinwonType2Created minwonType2Created = new MinwonType2Created(this);
        minwonType2Created.publishAfterCommit();

        MinwonType2Deleted minwonType2Deleted = new MinwonType2Deleted(this);
        minwonType2Deleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static MinwonType2Repository repository() {
        MinwonType2Repository minwonType2Repository = Process2Application.applicationContext.getBean(
            MinwonType2Repository.class
        );
        return minwonType2Repository;
    }

    //<<< Clean Arch / Port Method
    public void updateMinwonType2(
        UpdateMinwonType2Command updateMinwonType2Command
    ) {
        //implement business logic here:

        MinwonType2Updated minwonType2Updated = new MinwonType2Updated(this);
        minwonType2Updated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
