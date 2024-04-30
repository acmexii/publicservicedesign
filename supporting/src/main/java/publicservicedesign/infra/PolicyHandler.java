package publicservicedesign.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import publicservicedesign.config.kafka.KafkaProcessor;
import publicservicedesign.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InvestigationApproved'"
    )
    public void wheneverInvestigationApproved_알림서비스(
        @Payload InvestigationApproved investigationApproved
    ) {
        InvestigationApproved event = investigationApproved;
        System.out.println(
            "\n\n##### listener 알림서비스 : " + investigationApproved + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CompensationApproved'"
    )
    public void wheneverCompensationApproved_알림서비스(
        @Payload CompensationApproved compensationApproved
    ) {
        CompensationApproved event = compensationApproved;
        System.out.println(
            "\n\n##### listener 알림서비스 : " + compensationApproved + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CompensationPaymentCreated'"
    )
    public void wheneverCompensationPaymentCreated_알림서비스(
        @Payload CompensationPaymentCreated compensationPaymentCreated
    ) {
        CompensationPaymentCreated event = compensationPaymentCreated;
        System.out.println(
            "\n\n##### listener 알림서비스 : " +
            compensationPaymentCreated +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
