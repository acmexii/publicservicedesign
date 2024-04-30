package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CompensationApproved extends AbstractEvent {

    private String id;
    private String status;

    public CompensationApproved(RewardApplication aggregate) {
        super(aggregate);
    }

    public CompensationApproved() {
        super();
    }
}
//>>> DDD / Domain Event
