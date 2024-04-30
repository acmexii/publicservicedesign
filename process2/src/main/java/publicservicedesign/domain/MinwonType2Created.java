package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MinwonType2Created extends AbstractEvent {

    private String name;
    private String description;

    public MinwonType2Created(MinwonType2 aggregate) {
        super(aggregate);
    }

    public MinwonType2Created() {
        super();
    }
}
//>>> DDD / Domain Event
