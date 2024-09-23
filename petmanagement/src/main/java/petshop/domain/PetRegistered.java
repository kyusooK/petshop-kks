package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PetRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private Integer energy;
    private Integer appearance;
    private Address address;
    private PetType petType;
    private Photo photo;
    private PetStatus petStatus;

    public PetRegistered(Pet aggregate) {
        super(aggregate);
    }

    public PetRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
