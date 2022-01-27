package evgenulianov.task02_rest.repository;

import evgenulianov.task02_rest.model.MyUser;
import evgenulianov.task02_rest.service.Authorities;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void getUserAuthorities() {
        UserRepository repository = new UserRepository();

        List<Authorities> authorities= repository.getUserAuthorities(new MyUser("admin", "1"));

        assertEquals(authorities.size(), 3);
    }
}