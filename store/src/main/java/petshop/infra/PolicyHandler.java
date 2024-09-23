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
    ItemRepository itemRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PetRegistered'"
    )
    public void wheneverPetRegistered_Display(
        @Payload PetRegistered petRegistered
    ) {
        PetRegistered event = petRegistered;
        System.out.println(
            "\n\n##### listener Display : " + petRegistered + "\n\n"
        );

        // Sample Logic //
        Item.display(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Groomed'"
    )
    public void wheneverGroomed_ChangeInfo(@Payload Groomed groomed) {
        Groomed event = groomed;
        System.out.println(
            "\n\n##### listener ChangeInfo : " + groomed + "\n\n"
        );

        // Sample Logic //
        Item.changeInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Overweighted'"
    )
    public void wheneverOverweighted_ChangeInfo(
        @Payload Overweighted overweighted
    ) {
        Overweighted event = overweighted;
        System.out.println(
            "\n\n##### listener ChangeInfo : " + overweighted + "\n\n"
        );

        // Sample Logic //
        Item.changeInfo(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
