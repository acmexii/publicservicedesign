package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import publicservicedesign.CompensationApplication;
import publicservicedesign.domain.CompensationPaymentCreated;

@Entity
@Table(name = "CompensationPayment_table")
@Data
//<<< DDD / Aggregate Root
public class CompensationPayment {

    @Id
    private String id;

    @Embedded
    private Money amount;

    @PostPersist
    public void onPostPersist() {
        CompensationPaymentCreated compensationPaymentCreated = new CompensationPaymentCreated(
            this
        );
        compensationPaymentCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static CompensationPaymentRepository repository() {
        CompensationPaymentRepository compensationPaymentRepository = CompensationApplication.applicationContext.getBean(
            CompensationPaymentRepository.class
        );
        return compensationPaymentRepository;
    }
}
//>>> DDD / Aggregate Root
