package publicservicedesign.domain;

import lombok.Data;

@Data
public class UpdateInvestigationCommand {

    private String investigationId;
    private String result;
    private Boolean approve;
}
