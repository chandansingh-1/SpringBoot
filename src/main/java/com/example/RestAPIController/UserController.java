package com.example.RestAPIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    //Map<Integer, User> users = new HashMap<>();

    @GetMapping("/get_users")
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

//    @PostMapping("/add_user")
//    public void addUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age,
//                        @RequestParam("country") String country) {
//
//        User user = new User(id, name, country, age);
//        users.put(id, user);
//
//    }

    @PostMapping("/add_user_body")
    public ResponseEntity<String> addUserBody(@RequestBody(required=true) User user){

        userService.addUserToDB(user);
        return new ResponseEntity("One User Created Successfully", HttpStatus.CREATED);
    }

//    @GetMapping("/get_user/{id}")
//    public User getUser(@PathVariable("id") int x){
//        return users.get(x);
//    }
//
//    @PutMapping("/update/{id}")
//    public void updateUser(@PathVariable("id") int id, @RequestBody User user){
//        users.put(id, user);
//    }
//
//    @DeleteMapping("/del_user/{id}")
//    public void deleteUser(@PathVariable("id") int id){
//        users.remove(id);
//    }
}
