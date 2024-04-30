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

    @Autowired
    RewardApplicationRepository rewardApplicationRepository;

    @Autowired
    CompensationPaymentRepository compensationPaymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CompensationApproved'"
    )
    public void wheneverCompensationApproved_접수(
        @Payload CompensationApproved compensationApproved
    ) {
        CompensationApproved event = compensationApproved;
        System.out.println(
            "\n\n##### listener 접수 : " + compensationApproved + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
