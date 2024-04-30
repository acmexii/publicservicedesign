package publicservicedesign.domain;

import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

@Data
@ToString
public class CompensationPaymentCreated extends AbstractEvent {

    private String id;
    private Object amount;
}
