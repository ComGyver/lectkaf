package lectkaf.domain;

import java.time.LocalDate;
import java.util.*;
import lectkaf.domain.*;
import lectkaf.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryDecreased extends AbstractEvent {

    private Long id;
    private Integer stock;
    private String name;
    private Integer price;

    public InventoryDecreased(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
