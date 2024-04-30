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
    Analysis2Repository analysis2Repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RewardApplicationCreated'"
    )
    public void wheneverRewardApplicationCreated_데이터수집(
        @Payload RewardApplicationCreated rewardApplicationCreated
    ) {
        RewardApplicationCreated event = rewardApplicationCreated;
        System.out.println(
            "\n\n##### listener 데이터수집 : " +
            rewardApplicationCreated +
            "\n\n"
        );

        // Sample Logic //
        Analysis2.데이터수집(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CompensationApproved'"
    )
    public void wheneverCompensationApproved_데이터수집(
        @Payload CompensationApproved compensationApproved
    ) {
        CompensationApproved event = compensationApproved;
        System.out.println(
            "\n\n##### listener 데이터수집 : " + compensationApproved + "\n\n"
        );

        // Sample Logic //
        Analysis2.데이터수집(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
