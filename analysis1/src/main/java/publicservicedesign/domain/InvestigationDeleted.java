package publicservicedesign.domain;

import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

@Data
@ToString
public class InvestigationDeleted extends AbstractEvent {

    private String name;
}
