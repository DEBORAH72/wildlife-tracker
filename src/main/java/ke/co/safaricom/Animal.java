
package models;

import interfaces.AnimalInterface;
import ke.co.safaricom.Database;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal {


    private int animal_id;
    private String animal_name;
    private int id;

    public Animal(int animal_id, String animal_name){
        this.animal_id = animal_id;
        this.animal_name = animal_name;
        this.id = 0;
    }
    public static Animal setUpNewAnimal() {
        return new Animal(1, "Koala Bear");
    }


    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getAnimal_id() == animal.getAnimal_id() &&
                getId() == animal.getId() &&
                getAnimal_name().equals(animal.getAnimal_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnimal_id(), getAnimal_name(), getId());
    }

    @Override
    public void saveAnimal(Animal animal) {
        try (Connection conn = Database.sql2o.open()){
            String sql = "INSERT INTO  animals(animal_id, animal_name ) VALUES (:animal_id, :animal_name);";
            this.id = (int) conn.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("animal_name", this.animal_name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> getAllAnimals() {
        try(Connection conn = Database.sql2o.open()){
            String sql = "SELECT * FROM animals ORDER BY id DESC;";
            return conn.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }

    @Override
    public Animal findById(int id) {
        String sql = "SELECT * FROM animals WHERE id=:id;";
        try (Connection conn = Database.sql2o.open()){
            Animal animal = conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }catch (IndexOutOfBoundsException ex){
            System.out.println(ex);
            return null;
        }
    }

}