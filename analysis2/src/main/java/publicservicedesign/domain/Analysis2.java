package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import publicservicedesign.Analysis2Application;

@Entity
@Table(name = "Analysis2_table")
@Data
//<<< DDD / Aggregate Root
public class Analysis2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static Analysis2Repository repository() {
        Analysis2Repository analysis2Repository = Analysis2Application.applicationContext.getBean(
            Analysis2Repository.class
        );
        return analysis2Repository;
    }

    //<<< Clean Arch / Port Method
    public static void 데이터수집(
        RewardApplicationCreated rewardApplicationCreated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Analysis2 analysis2 = new Analysis2();
        repository().save(analysis2);

        */

        /** Example 2:  finding and process
        
        repository().findById(rewardApplicationCreated.get???()).ifPresent(analysis2->{
            
            analysis2 // do something
            repository().save(analysis2);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void 데이터수집(CompensationApproved compensationApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Analysis2 analysis2 = new Analysis2();
        repository().save(analysis2);

        */

        /** Example 2:  finding and process
        
        repository().findById(compensationApproved.get???()).ifPresent(analysis2->{
            
            analysis2 // do something
            repository().save(analysis2);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
