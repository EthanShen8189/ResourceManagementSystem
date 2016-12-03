package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.User;

import java.util.List;

/**
 * Created by EthanShen on 2016-12-03.
 */
public interface UserDao {

    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String username, int departID);
    User getUserById(String username, int departID);
    List<User> getAllReservation();


}
