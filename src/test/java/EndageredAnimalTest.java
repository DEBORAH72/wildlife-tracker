package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Test
    public void setAnimal_id_SetsAnimalId() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        newAnimal.setAnimal_id(1);
        assertEquals(1, newAnimal.getAnimal_id());
    }

    @Test
    public void getAnimal_name() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        assertEquals("Porcupine",newAnimal.getAnimal_name());
    }

    @Test
    public void getAnimal_health() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        assertEquals("healthy",newAnimal.getAnimal_health());
    }

    @Test
    public void getAnimal_age() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        assertEquals("Young",newAnimal.getAnimal_age());
    }

    @Test
    public void getId() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        assertEquals(1,newAnimal.getId());
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void saveAnimal() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        newAnimal.saveAnimal(newAnimal);
        int initialId = newAnimal.getId();
        assertEquals(initialId,newAnimal.getId());
    }


    @Test
    public void getAllAnimals() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        newAnimal.saveAnimal(newAnimal);
        assertTrue(EndangeredAnimal.getAllAnimals().contains(newAnimal.findById(newAnimal.getId())));
    };

    @Test
    public void findById() {
        EndangeredAnimal newAnimal = EndangeredAnimal.newEndangeredAnimal();
        newAnimal.saveAnimal(newAnimal);
        assertEquals(newAnimal,EndangeredAnimal.getAllAnimals().get(0));
    }
}