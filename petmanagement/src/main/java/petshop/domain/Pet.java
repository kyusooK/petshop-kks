package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.PetmanagementApplication;
import petshop.domain.Overweighted;
import petshop.domain.PetRegistered;

@Entity
@Table(name = "Pet_table")
@Data
//<<< DDD / Aggregate Root
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer energy;

    private Integer appearance;

    @Embedded
    private Address address;

    @Embedded
    private PetType petType;

    @Embedded
    private Photo photo;

    @Embedded
    private PetStatus petStatus;

    @ElementCollection
    private List<IllnessHistory> illnessHistories;

    @PostPersist
    public void onPostPersist() {
        PetRegistered petRegistered = new PetRegistered(this);
        petRegistered.publishAfterCommit();

        Overweighted overweighted = new Overweighted(this);
        overweighted.publishAfterCommit();
    }

    public static PetRepository repository() {
        PetRepository petRepository = PetmanagementApplication.applicationContext.getBean(
            PetRepository.class
        );
        return petRepository;
    }

    public void register() {
        //implement business logic here:

        PetRegistered petRegistered = new PetRegistered(this);
        petRegistered.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public void feed(FeedCommand feedCommand) {
        //implement business logic here:

        Fed fed = new Fed(this);
        fed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void sleep(SleepCommand sleepCommand) {
        //implement business logic here:

        Slept slept = new Slept(this);
        slept.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void groom(GroomCommand groomCommand) {
        //implement business logic here:

        Groomed groomed = new Groomed(this);
        groomed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void updateStatus(Adopted adopted) {
        //implement business logic here:

        /** Example 1:  new item 
        Pet pet = new Pet();
        repository().save(pet);

        */

        /** Example 2:  finding and process
        
        repository().findById(adopted.get???()).ifPresent(pet->{
            
            pet // do something
            repository().save(pet);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(Dissoluted dissoluted) {
        //implement business logic here:

        /** Example 1:  new item 
        Pet pet = new Pet();
        repository().save(pet);

        */

        /** Example 2:  finding and process
        
        repository().findById(dissoluted.get???()).ifPresent(pet->{
            
            pet // do something
            repository().save(pet);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
