package publicservicedesign.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import publicservicedesign.domain.*;

@Component
public class MinwonType2HateoasProcessor
    implements RepresentationModelProcessor<EntityModel<MinwonType2>> {

    @Override
    public EntityModel<MinwonType2> process(EntityModel<MinwonType2> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/process")
                .withRel("process")
        );

        return model;
    }
}
