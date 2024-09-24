package petshop.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import lombok.Data;
import petshop.PetmanagementApplication;

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

    private Integer weight;

    private Integer appearance;

    @Embedded
    private PetType petType;

    @Embedded
    private Photo photo;

    @Embedded
    private PetStatus petStatus;

    @PostPersist
    public void onPostPersist() {
        PetRegistered petRegistered = new PetRegistered(this);
        petRegistered.publishAfterCommit();
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
      
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void sleep(SleepCommand sleepCommand) {
        //implement business logic here:

        energy = energy + 1;
        appearance = appearance + 1;

        Slept slept = new Slept(this);
        slept.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void groom(GroomCommand groomCommand) {
        //implement business logic here:

        appearance = appearance + 1;

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
