package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MinwonType2Updated extends AbstractEvent {

    private String name;
    private String description;

    public MinwonType2Updated(MinwonType2 aggregate) {
        super(aggregate);
    }

    public MinwonType2Updated() {
        super();
    }
}
//>>> DDD / Domain Event
