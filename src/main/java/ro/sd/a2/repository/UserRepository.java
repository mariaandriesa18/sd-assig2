package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.role = 'user'")
    List<User> findAllRegularUsers();

    @Query("select u from User u where u.username = :username")
    User findUserByUsername(@Param("username")String username);

   // @Query("select u from User u where u.email = :email")
    User findByEmail(String email);//@Param("email")String email);

    @Query("select u from User u where u.name = :name")
    User findByName(@Param("name") String name);


}
