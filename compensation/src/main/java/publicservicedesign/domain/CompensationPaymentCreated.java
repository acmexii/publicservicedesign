package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CompensationPaymentCreated extends AbstractEvent {

    private String id;
    private Money amount;

    public CompensationPaymentCreated(CompensationPayment aggregate) {
        super(aggregate);
    }

    public CompensationPaymentCreated() {
        super();
    }
}
//>>> DDD / Domain Event
