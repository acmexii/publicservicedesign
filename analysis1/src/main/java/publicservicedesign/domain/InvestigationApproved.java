package publicservicedesign.domain;

import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

@Data
@ToString
public class InvestigationApproved extends AbstractEvent {

    private String name;
    private String description;
    private Date date;
}
