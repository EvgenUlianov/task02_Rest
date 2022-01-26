package evgenulianov.task02_rest.repository;

import evgenulianov.task02_rest.service.Authorities;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    @Data
    @AllArgsConstructor
    private class MyUser{
        private String userName;
        transient private String password;

        private void setPassword(String password){this.password = password;}
        private String getPassword(){ return password;}

        @Override
        public String toString(){
            return userName;
        }

    }

    final private Map<MyUser, List<Authorities>> userListMap;

    public UserRepository() {
        userListMap = new LinkedHashMap<>();

        userListMap.put(new UserRepository.MyUser("admin", "1"), Arrays.stream((new Authorities[] {
                Authorities.READ,
                Authorities.DELETE,
                Authorities.WRITE})).collect(Collectors.toList()));
        userListMap.put(new UserRepository.MyUser("reader", "reader1"), Arrays.stream((new Authorities[] {
                Authorities.READ})).collect(Collectors.toList()));
        userListMap.put(new UserRepository.MyUser("deleter", "deleter1"), Arrays.stream((new Authorities[] {
                Authorities.DELETE})).collect(Collectors.toList()));
        userListMap.put(new UserRepository.MyUser("writer", "writer1"), Arrays.stream((new Authorities[] {
                Authorities.WRITE})).collect(Collectors.toList()));
    }

    public List<Authorities> getUserAuthorities(String userName, String password) {

        UserRepository.MyUser chekingUser = new UserRepository.MyUser(userName, password);
        List<Authorities> authorities = userListMap.get(chekingUser);
        if (authorities == null)
            return new ArrayList<>();
        return authorities;
    }
}