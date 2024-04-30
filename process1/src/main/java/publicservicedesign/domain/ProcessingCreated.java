package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProcessingCreated extends AbstractEvent {

    private String name;
    private Date date;

    public ProcessingCreated(Processing aggregate) {
        super(aggregate);
    }

    public ProcessingCreated() {
        super();
    }
}
//>>> DDD / Domain Event
