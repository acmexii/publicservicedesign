package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InvestigationCreated extends AbstractEvent {

    private String name;
    private String description;
    private Date date;

    public InvestigationCreated(Investigation aggregate) {
        super(aggregate);
    }

    public InvestigationCreated() {
        super();
    }
}
//>>> DDD / Domain Event
