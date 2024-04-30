package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProcessingDeleted extends AbstractEvent {

    private String name;

    public ProcessingDeleted(Processing aggregate) {
        super(aggregate);
    }

    public ProcessingDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
