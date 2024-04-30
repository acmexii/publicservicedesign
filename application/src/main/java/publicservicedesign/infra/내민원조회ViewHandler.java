package publicservicedesign.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import publicservicedesign.config.kafka.KafkaProcessor;
import publicservicedesign.domain.*;

@Service
public class 내민원조회ViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private 내민원조회Repository 내민원조회Repository;
    //>>> DDD / CQRS
}
