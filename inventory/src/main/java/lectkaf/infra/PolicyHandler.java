package lectkaf.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import lectkaf.config.kafka.KafkaProcessor;
import lectkaf.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DevliveryStarted'"
    )
    public void wheneverDevliveryStarted_DecreaseInventory(
        @Payload DevliveryStarted devliveryStarted
    ) {
        DevliveryStarted event = devliveryStarted;
        System.out.println(
            "\n\n##### listener DecreaseInventory : " +
            devliveryStarted +
            "\n\n"
        );

        // Sample Logic //
        Inventory.decreaseInventory(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
