package com.example.authdemo.controller;

import com.example.authdemo.entity.UsersInformation;
import com.example.authdemo.repository.UsersInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersInformationController {

    @Autowired
    private UsersInformationRepository usersInformationRepository;

    @GetMapping
    public List<UsersInformation> getAllUsers() {
        return usersInformationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersInformation> getUserById(@PathVariable int id) {
        Optional<UsersInformation> user = usersInformationRepository.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsersInformation createUser(@RequestBody UsersInformation usersInformation) {
        return usersInformationRepository.save(usersInformation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersInformation> updateUser(@PathVariable int id, @RequestBody UsersInformation userDetails) {
        Optional<UsersInformation> user = usersInformationRepository.findById(id);
        if (user.isPresent()) {
            UsersInformation updatedUser = user.get();
            updatedUser.setUsername(userDetails.getUsername());
            updatedUser.setSurname(userDetails.getSurname());
            updatedUser.setAge(userDetails.getAge());
            updatedUser.setKimlikno(userDetails.getKimlikno());
            updatedUser.setDatetime(userDetails.getDatetime());
            return ResponseEntity.ok(usersInformationRepository.save(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        Optional<UsersInformation> user = usersInformationRepository.findById(id);
        if (user.isPresent()) {
            usersInformationRepository.delete(user.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



    /*@GetMapping("/getAll")
    public List<UsersInformation> getAllUsers() {
        List<UsersInformation> usersList = new ArrayList<>();
        usersList.add(new UsersInformation("1","user1", "234234"));
        usersList.add(new UsersInformation("2","user2", "232342"));
        usersList.add(new UsersInformation("3","user3", "12131231"));

    return usersList;
    }

    @GetMapping("/getAllWithParam")
    @ResponseBody
    public List<UsersInformation> getAllUsersWithRequestParam(@RequestParam String username) {
        List<UsersInformation> usersList = new ArrayList<>();
        usersList.add(new UsersInformation("1","user1", "234234"));
        usersList.add(new UsersInformation("2","user2", "232342"));
        usersList.add(new UsersInformation("3","user3", "12131231"));

        return usersList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }


    @GetMapping("/getAllWithBody")
    @ResponseBody
    public List<UsersInformation> getAllUsersWithRequestBody(@RequestBody UsersInformation usersInformation) {
        List<UsersInformation> usersList = new ArrayList<>();
        usersList.add(new UsersInformation("1","user1", "234234"));
        usersList.add(new UsersInformation("2","user2", "232342"));
        usersList.add(new UsersInformation("3","user3", "12131231"));

        List<UsersInformation> filteredList = new ArrayList<>();
        for (UsersInformation user : usersList) {
            if (user.getUsername().equalsIgnoreCase(usersInformation.getUsername())) {
                filteredList.add(user);
            }
        }

        return filteredList;
    }
    @GetMapping("/getAll/{id}")
    @ResponseBody
    public UsersInformation getUserById(@PathVariable String id) {
        List<UsersInformation> usersList = new ArrayList<>();
        usersList.add(new UsersInformation("1", "user1", "234234"));
        usersList.add(new UsersInformation("2", "user2", "232342"));
        usersList.add(new UsersInformation("3", "user3", "12131231"));

        for (UsersInformation user : usersList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        // Eğer id bulunamazsa null dönebiliriz veya hata fırlatabiliriz.
        return null;
    }*/



/*@GetMapping("/getAll")
    public UsersInformation getUsersInformation() {
    List<UsersInformation> usersInformation1 = new ArrayList<>();
    usersInformation1.add(new UsersInformation(""));
    usersInformation1.add(new UsersInformation(""));
    return (UsersInformation) (UsersInformation) usersInformation1;
    }*/

