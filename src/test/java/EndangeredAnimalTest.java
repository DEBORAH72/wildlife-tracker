package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndangeredAnimalTest {

    @Test
    public void setAnimal_id_SetsAnimalId() {
        Object EndangeredAnimal;
        models.EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        newAnimal.setAnimal_id(1);
        assertEquals(1, newAnimal.getAnimal_id());
    }

    @Test
    public void getAnimal_name() {
        Object EndangeredAnimal;
        models.EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        assertEquals("Porcupine", newAnimal.getAnimal_name());
    }

    @Test
    public void getAnimal_health() {
        EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        assertEquals("healthy", newAnimal.getAnimal_health());
    }

    @Test
    public void getAnimal_age() {
        EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        assertEquals("Young", newAnimal.getAnimal_age());
    }

    @Test
    public void getId() {
        EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        assertEquals(1, newAnimal.getId());
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void saveAnimal() {
        EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        newAnimal.saveAnimal();
        int initialId = newAnimal.getId();
        assertEquals(initialId, newAnimal.getId());
    }

    @Test
    public void getAllAnimals() {
        EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        newAnimal.saveAnimal();
        assertTrue(EndangeredAnimal.getAllAnimals().contains(newAnimal));
    }

    @Test
    public void findById() {
        EndangeredAnimal newAnimal = EndangeredAnimal.setUpNewEndangeredAnimal();
        newAnimal.saveAnimal();
        assertEquals(newAnimal, EndangeredAnimal.findById(newAnimal.getId()));
    }
}
