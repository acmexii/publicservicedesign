package publicservicedesign.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import publicservicedesign.domain.*;

@Component
public class ProcessingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Processing>> {

    @Override
    public EntityModel<Processing> process(EntityModel<Processing> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//process")
                .withRel("/process")
        );

        return model;
    }
}
