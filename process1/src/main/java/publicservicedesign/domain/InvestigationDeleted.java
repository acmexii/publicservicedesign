package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InvestigationDeleted extends AbstractEvent {

    private String name;

    public InvestigationDeleted(Investigation aggregate) {
        super(aggregate);
    }

    public InvestigationDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
