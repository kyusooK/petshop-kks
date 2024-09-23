package petshop.domain;

import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
@ToString
public class Groomed extends AbstractEvent {

    private Long id;
    private String name;
    private Integer energy;
    private Integer appearance;
    private Object petStatus;
}
