package publicservicedesign.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import publicservicedesign.domain.*;

@Component
public class Analysis2HateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Analysis2>> {

    @Override
    public EntityModel<Analysis2> process(EntityModel<Analysis2> model) {
        return model;
    }
}
