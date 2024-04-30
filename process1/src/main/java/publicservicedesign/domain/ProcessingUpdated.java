package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProcessingUpdated extends AbstractEvent {

    private String name;
    private Date date;

    public ProcessingUpdated(Processing aggregate) {
        super(aggregate);
    }

    public ProcessingUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
