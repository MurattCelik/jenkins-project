package com.mcelik.jenkinsproject.api;

import com.mcelik.jenkinsproject.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserApi {

    List<User> userList = new ArrayList<>();

    @PostConstruct
    public void init() {
        User user = new User("342","Murat","Celik","Istanbul","534534534");
        User user2 = new User("322","Merve","Gun","Izmir","523523532");
        userList.add(user);
        userList.add(user2);
    }


    @GetMapping(value = "/list")
    public List<User> userList() {
        return userList;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {

        Optional<User> first = userList.stream().filter(s -> s.getId().equals(id)).findFirst();
        if ((first.isPresent())) {
            return first.get();
        }

        return null;
    }

    @PostMapping(value = "/save")
    public void saveUser(@RequestBody User user) {
        userList.add(user);
    }

}
