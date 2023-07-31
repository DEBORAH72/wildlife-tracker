package ke.co.safaricom;

public class Animal {
    public int id;
    public String name;
    public String type;

    // Constants for animal types
    public static final String NON_ENDANGERED_TYPE = "Non-endangered";
    public static final String ENDANGERED_TYPE = "Endangered";

    public Animal(String name, String type) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Please enter an animal name.");
        }
        this.name = name;

        // Validate the animal type to be either "Non-endangered" or "Endangered"
        if (type.equals(NON_ENDANGERED_TYPE) || type.equals(ENDANGERED_TYPE)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid animal type. Supported types: Non-endangered, Endangered.");
        }
    }

    public Animal() {

    }

    // Rest of the class methods remain the same...

    //...
}
