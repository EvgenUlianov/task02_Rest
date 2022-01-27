package evgenulianov.task02_rest.repository;

import evgenulianov.task02_rest.model.MyUser;
import evgenulianov.task02_rest.service.Authorities;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    final private Map<MyUser, List<Authorities>> userListMap;

    public UserRepository() {
        userListMap = new LinkedHashMap<>();

        userListMap.put(new MyUser("admin", "1"), Arrays.stream((new Authorities[] {
                Authorities.READ,
                Authorities.DELETE,
                Authorities.WRITE})).collect(Collectors.toList()));
        userListMap.put(new MyUser("reader", "reader1"), Arrays.stream((new Authorities[] {
                Authorities.READ})).collect(Collectors.toList()));
        userListMap.put(new MyUser("deleter", "deleter1"), Arrays.stream((new Authorities[] {
                Authorities.DELETE})).collect(Collectors.toList()));
        userListMap.put(new MyUser("writer", "writer1"), Arrays.stream((new Authorities[] {
                Authorities.WRITE})).collect(Collectors.toList()));
    }

    public List<Authorities> getUserAuthorities(MyUser chekingUser) {

        List<Authorities> authorities = userListMap.get(chekingUser);
        if (authorities == null)
            return new ArrayList<>();
        return authorities;
    }
}