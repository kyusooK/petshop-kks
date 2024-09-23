package petshop.domain;

import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
@ToString
public class Dissoluted extends AbstractEvent {

    private Long id;
    private Object price;
    private Object customer;
    private Object status;
    private Object petId;
}
