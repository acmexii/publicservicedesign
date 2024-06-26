package publicservicedesign.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import publicservicedesign.domain.*;

@Component
public class InvestigationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Investigation>> {

    @Override
    public EntityModel<Investigation> process(
        EntityModel<Investigation> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/update")
                .withRel("update")
        );

        return model;
    }
}
