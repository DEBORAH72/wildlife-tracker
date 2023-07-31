package models;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {



    @Test
    public void setId() {
        Animal newAnimal = Animal.setUpNewAnimal();
        newAnimal.setId(3);
        assertEquals(3,newAnimal.getId());
    }

    @Test
    public void getName() {
        Animal newAnimal = Animal.setUpNewAnimal();
        assertEquals("Koala Bear",newAnimal.getAnimal_name());
    }

    @Test
    public void setName() {
        Animal newAnimal = Animal.setUpNewAnimal();
        newAnimal.setAnimal_name("Hyena");
        assertEquals("Hyena",newAnimal.getAnimal_name());
    }

    @Test
    public void equals() {
        Animal newAnimal = Animal.setUpNewAnimal();
        newAnimal.saveAnimal(newAnimal);
        assertEquals(newAnimal.getId(),newAnimal.findById(newAnimal.getId()).getId());

    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void saveAnimal() {
        Animal newAnimal = Animal.setUpNewAnimal();
        EndangeredAnimal newDanger = new EndangeredAnimal("Rhino","ill","young");
        newDanger.saveAnimal(newDanger);
        int initialId = newAnimal.getId();
        newAnimal.saveAnimal(newAnimal);
        assertNotEquals(initialId,newAnimal.getId());
    }
    @Test
    public void getAllAnimals() throws Exception{
        Animal newAnimal = Animal.setUpNewAnimal();
        newAnimal.saveAnimal(newAnimal);
        assertTrue(Animal.getAllAnimals().contains(newAnimal.findById(newAnimal.getId())));
    }

    @Test
    public void findAnimalById() {
        Animal newAnimal = Animal.setUpNewAnimal();
        newAnimal.saveAnimal(newAnimal);
        assertEquals(newAnimal.getId(), newAnimal.findById(newAnimal.getId()).getId());
    }


}