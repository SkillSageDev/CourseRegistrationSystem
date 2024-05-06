public abstract class Person {
    String name;
    String email;
    int id;
    char gender;
    String dateOfBirth;
    String address;

    public Person(String name, String email, int id, char gender, String dateOfBirth, String address) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public abstract void displayDetails();
}