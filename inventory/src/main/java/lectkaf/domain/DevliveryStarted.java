package lectkaf.domain;

import java.util.*;
import lectkaf.domain.*;
import lectkaf.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class DevliveryStarted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String productId;
    private Integer qty;
    private String address;
}
