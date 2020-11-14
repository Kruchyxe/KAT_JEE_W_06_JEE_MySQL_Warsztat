package pl.coderslab.entity;

public class MainDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("Katarzyna");
        user.setEmail("kasiapik@interia.eu");
        user.setPassword("Bimbos123");
        userDao.insert(user);
    }
}
