package publicservicedesign.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
import publicservicedesign.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InvestigationApproved extends AbstractEvent {

    private String description;
    private Date date;
    private String name;
    private String 민원번호;
    private String status;

    public InvestigationApproved(Investigation aggregate) {
        super(aggregate);
    }

    public InvestigationApproved() {
        super();
    }
}
// >>> DDD / Domain Event
