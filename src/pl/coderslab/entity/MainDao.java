package pl.coderslab.entity;

public class MainDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUserName("Alfred");
//        user.setEmail("jabaduu@yahoo.com");
//        user.setPassword("Inch2two");
//        userDao.insert(user);


        User userToUpdate = new User();
        userToUpdate.setId(5);
        userToUpdate.setUserName("Alfred");
        userToUpdate.setEmail("jabaduu@yahoo.com");
        userToUpdate.setPassword("Inch123two");
        userDao.update(userToUpdate);

//        User read = userDao.read(2); // nie działa
//        System.out.println(read);

//        userDao.delete(4);





    }
}
