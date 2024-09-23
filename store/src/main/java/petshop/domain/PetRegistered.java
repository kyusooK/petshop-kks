package petshop.domain;

import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
@ToString
public class PetRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private Integer energy;
    private Integer appearance;
    private Object address;
    private Object petType;
    private Object photo;
    private Object petStatus;
}
