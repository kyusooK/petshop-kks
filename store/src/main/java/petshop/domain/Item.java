package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.StoreApplication;
import petshop.domain.Adopted;
import petshop.domain.Dissoluted;
import petshop.domain.ItemAdded;
import petshop.domain.PriceSet;

@Entity
@Table(name = "Item_table")
@Data
//<<< DDD / Aggregate Root
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Money price;

    @Embedded
    private User customer;

    @Embedded
    private Status status;

    @Embedded
    private PetId petId;

    @PostPersist
    public void onPostPersist() {
        ItemAdded itemAdded = new ItemAdded(this);
        itemAdded.publishAfterCommit();

        PriceSet priceSet = new PriceSet(this);
        priceSet.publishAfterCommit();

        Dissoluted dissoluted = new Dissoluted(this);
        dissoluted.publishAfterCommit();

        Adopted adopted = new Adopted(this);
        adopted.publishAfterCommit();
    }

    public static ItemRepository repository() {
        ItemRepository itemRepository = StoreApplication.applicationContext.getBean(
            ItemRepository.class
        );
        return itemRepository;
    }

    public void setPrice() {
        //implement business logic here:

        PriceSet priceSet = new PriceSet(this);
        priceSet.publishAfterCommit();
    }

    public void dissolute() {
        //implement business logic here:

        Dissoluted dissoluted = new Dissoluted(this);
        dissoluted.publishAfterCommit();
    }

    public void adopt() {
        //implement business logic here:

        Adopted adopted = new Adopted(this);
        adopted.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void display(PetRegistered petRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        ItemAdded itemAdded = new ItemAdded(item);
        itemAdded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(petRegistered.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);

            ItemAdded itemAdded = new ItemAdded(item);
            itemAdded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeInfo(Groomed groomed) {
        //implement business logic here:

        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        */

        /** Example 2:  finding and process
        
        repository().findById(groomed.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeInfo(Overweighted overweighted) {
        //implement business logic here:

        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        */

        /** Example 2:  finding and process
        
        repository().findById(overweighted.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
