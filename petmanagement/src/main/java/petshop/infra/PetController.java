package petshop.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petshop.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/pets")
@Transactional
public class PetController {

    @Autowired
    PetRepository petRepository;

    @RequestMapping(
        value = "/pets/{id}//feed",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Pet feed(
        @PathVariable(value = "id") Long id,
        @RequestBody FeedCommand feedCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /pet/feed  called #####");
        Optional<Pet> optionalPet = petRepository.findById(id);

        optionalPet.orElseThrow(() -> new Exception("No Entity Found"));
        Pet pet = optionalPet.get();
        pet.feed(feedCommand);

        petRepository.save(pet);
        return pet;
    }

    @RequestMapping(
        value = "/pets/{id}//sleep",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Pet sleep(
        @PathVariable(value = "id") Long id,
        @RequestBody SleepCommand sleepCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /pet/sleep  called #####");
        Optional<Pet> optionalPet = petRepository.findById(id);

        optionalPet.orElseThrow(() -> new Exception("No Entity Found"));
        Pet pet = optionalPet.get();
        pet.sleep(sleepCommand);

        petRepository.save(pet);
        return pet;
    }

    @RequestMapping(
        value = "/pets/{id}//groom",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Pet groom(
        @PathVariable(value = "id") Long id,
        @RequestBody GroomCommand groomCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /pet/groom  called #####");
        Optional<Pet> optionalPet = petRepository.findById(id);

        optionalPet.orElseThrow(() -> new Exception("No Entity Found"));
        Pet pet = optionalPet.get();
        pet.groom(groomCommand);

        petRepository.save(pet);
        return pet;
    }
}
//>>> Clean Arch / Inbound Adaptor
