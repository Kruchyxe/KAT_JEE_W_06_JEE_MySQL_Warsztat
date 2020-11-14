package pl.coderslab.entity;

import java.sql.*;

public class UserDao {

    /** Query creating User in DB  */
    private static final String CREATE_USER =
            "INSERT INTO users (username, email, password) VALUES (?, ?, ?);";

    /** Query read from DB by userId  */
    private static final String READ_USER =
            "SELECT * FROM users WHERE id = ?;";

    /** Query to update User in DB  */
    private static final String UPDATE_USER =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;";

    /** Query to delete user from DB  */
    private static final String DELETE_USER =
            "DELETE FROM users WHERE id = ?;";

    /** */


    public User insert(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update (User user){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, this.hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public User read(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_USER);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete (int userId){
        try (Connection conn = DbUtil.getConnection()) {
                PreparedStatement statement = conn.prepareStatement(DELETE_USER);
                statement.setInt(1, userId);
                statement.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    public String hashPassword(String password){
        return org.mindrot.jbcrypt.BCrypt.hashpw(password, org.mindrot.jbcrypt.BCrypt.gensalt());
    }


}
