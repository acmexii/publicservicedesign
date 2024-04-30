package publicservicedesign.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateMinwonType2Command {

    private String name;
    private String description;
}
