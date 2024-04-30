package publicservicedesign.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import publicservicedesign.domain.*;

@Component
public class RewardApplicationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<RewardApplication>> {

    @Override
    public EntityModel<RewardApplication> process(
        EntityModel<RewardApplication> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/status")
                .withRel("status")
        );

        return model;
    }
}
