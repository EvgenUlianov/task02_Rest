package evgenulianov.task02_rest.service;

import evgenulianov.task02_rest.model.MyUser;
import evgenulianov.task02_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(MyUser checkingUser) {

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(checkingUser);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + checkingUser.getUserName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}