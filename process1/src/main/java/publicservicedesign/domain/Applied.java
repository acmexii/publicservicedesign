package publicservicedesign.domain;

import java.util.*;
import lombok.*;
import publicservicedesign.domain.*;
import publicservicedesign.infra.AbstractEvent;

@Data
@ToString
public class Applied extends AbstractEvent {

    private String 민원번호;
    private String 민원내용;
}
