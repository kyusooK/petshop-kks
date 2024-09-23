package petshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.config.kafka.KafkaProcessor;
import petshop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PetRepository petRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Adopted'"
    )
    public void wheneverAdopted_UpdateStatus(@Payload Adopted adopted) {
        Adopted event = adopted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + adopted + "\n\n"
        );

        // Sample Logic //
        Pet.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Dissoluted'"
    )
    public void wheneverDissoluted_UpdateStatus(
        @Payload Dissoluted dissoluted
    ) {
        Dissoluted event = dissoluted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + dissoluted + "\n\n"
        );

        // Sample Logic //
        Pet.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
