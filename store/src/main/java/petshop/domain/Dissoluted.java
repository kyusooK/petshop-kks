package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Dissoluted extends AbstractEvent {

    private Long id;
    private Money price;
    private User customer;
    private Status status;
    private PetId petId;

    public Dissoluted(Item aggregate) {
        super(aggregate);
    }

    public Dissoluted() {
        super();
    }
}
//>>> DDD / Domain Event
