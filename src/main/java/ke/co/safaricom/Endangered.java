package ke.co.safaricom;

import org.sql2o.Connection;
import org.apache.commons.lang3.StringUtils;

public class Endangered extends Animal {
    public String health;
    public String age;
    public static final String ANIMAL_TYPE = "Endangered";

    public Endangered(String name, String health, String age) {
        super();
        // Remove the call to super(name) as 'name' is already inherited from Animal.
        if (StringUtils.isBlank(name) || StringUtils.isBlank(health) || StringUtils.isBlank(age)) {
            throw new IllegalArgumentException("Please enter all input fields.");
        }
        this.name = name;
        this.health = health;
        this.age = age;
        type = ANIMAL_TYPE;
    }

    // Rest of the class remains the same...
}
