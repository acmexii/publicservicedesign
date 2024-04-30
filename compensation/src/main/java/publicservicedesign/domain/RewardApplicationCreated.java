package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RewardApplicationCreated extends AbstractEvent {

    private String id;
    private String reason;

    public RewardApplicationCreated(RewardApplication aggregate) {
        super(aggregate);
    }

    public RewardApplicationCreated() {
        super();
    }
}
//>>> DDD / Domain Event
