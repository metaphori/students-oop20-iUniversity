package iuniversity.model.user;

public abstract class AbstractUser implements User {

    private String name;
    private String lastName;
    private String username;
    private String dateOfBirth;
    private Gender gender;
    private String address;
    private int id;
    
    public AbstractUser(String name, String lastName, String username, String dateOfBirth, Gender gender,
            String address, int id) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getAddress() {
        return this.address;
    }

    public int getId() {
        return this.id;
    }

}
