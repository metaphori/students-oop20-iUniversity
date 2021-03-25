package iuniversity.model.user;

public class AdminImpl extends AbstractUser implements Admin {

    public AdminImpl(String name, String lastName, String username, String dateOfBirth, Gender gender, String address,
            int id) {
        super(name, lastName, username, dateOfBirth, gender, address, id);
    }

}
