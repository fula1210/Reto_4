package Reto4._back.interfaces;

import Reto4._back.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceUser extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    //Optional<User> findTopByOrderByIdDesc();
}
