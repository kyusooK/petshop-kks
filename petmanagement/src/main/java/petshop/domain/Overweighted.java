package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Overweighted extends AbstractEvent {

    private Long id;
    private String name;
    private Integer energy;
    private Integer appearance;
    private PetStatus petStatus;

    public Overweighted(Pet aggregate) {
        super(aggregate);
    }

    public Overweighted() {
        super();
    }
}
//>>> DDD / Domain Event
