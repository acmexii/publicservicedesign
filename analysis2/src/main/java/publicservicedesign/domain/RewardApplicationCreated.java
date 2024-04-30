package publicservicedesign.domain;

import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

@Data
@ToString
public class RewardApplicationCreated extends AbstractEvent {

    private String id;
    private String reason;
}
