package publicservicedesign.infra;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import publicservicedesign.config.kafka.KafkaProcessor;
import publicservicedesign.domain.Applied;
import publicservicedesign.domain.Investigation;
import publicservicedesign.domain.InvestigationApproved;
import publicservicedesign.domain.InvestigationRepository;
import publicservicedesign.domain.Processing;
import publicservicedesign.domain.ProcessingRepository;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InvestigationRepository investigationRepository;

    @Autowired
    ProcessingRepository processingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {
    }

    @StreamListener(value = KafkaProcessor.INPUT, condition = "headers['type']=='Applied'")
    @Transactional
    public void wheneverApplied_접수(@Payload Applied applied) {
        System.out.println("\n\n##### listener 접수 : " + applied + "\n\n");

        // Sample Logic //
        Investigation investigation = new Investigation();
        // anti-corruption is needed
        investigation.set민원번호(applied.get민원번호());
        investigation.setDescription(applied.get민원내용());
        investigation.setName("INV" + applied.get민원번호());

        investigationRepository.save(investigation);
    }

    @StreamListener(value = KafkaProcessor.INPUT, condition = "headers['type']=='InvestigationApproved'")
    @Transactional
    public void wheneverInvestigationApproved_처리건접수(
            @Payload InvestigationApproved investigationApproved) {
        System.out.println(
                "\n\n##### listener 처리건접수 : " + investigationApproved + "\n\n");
        // Sample Logic //
        Processing processing = new Processing();
        processing.set민원번호(investigationApproved.get민원번호());
        processing.setName(investigationApproved.getDescription());

        processingRepository.save(processing);
    }
}
// >>> Clean Arch / Inbound Adaptor
