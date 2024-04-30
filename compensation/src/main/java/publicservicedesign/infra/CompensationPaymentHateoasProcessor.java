package publicservicedesign.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import publicservicedesign.domain.*;

@Component
public class CompensationPaymentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CompensationPayment>> {

    @Override
    public EntityModel<CompensationPayment> process(
        EntityModel<CompensationPayment> model
    ) {
        return model;
    }
}
