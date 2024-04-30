package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateCompensationReviewStatusCommand {

    private String id;
    private String status;
}
