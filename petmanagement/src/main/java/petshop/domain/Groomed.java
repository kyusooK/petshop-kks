package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Groomed extends AbstractEvent {

    private Long id;
    private String name;
    private Integer energy;
    private Integer appearance;
    private PetStatus petStatus;

    public Groomed(Pet aggregate) {
        super(aggregate);
    }

    public Groomed() {
        super();
    }
}
//>>> DDD / Domain Event
