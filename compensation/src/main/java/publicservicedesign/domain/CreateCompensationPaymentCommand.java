package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateCompensationPaymentCommand {

    private String id;
    private Money amount;
}
