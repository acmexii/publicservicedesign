package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MinwonType2Deleted extends AbstractEvent {

    private String name;

    public MinwonType2Deleted(MinwonType2 aggregate) {
        super(aggregate);
    }

    public MinwonType2Deleted() {
        super();
    }
}
//>>> DDD / Domain Event
