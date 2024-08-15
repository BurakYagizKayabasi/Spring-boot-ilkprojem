package com.example.authdemo;

import com.example.authdemo.entity.UsersInformation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication
public class AuthdemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(AuthdemoApplication.class, args);
      /*
        UsersInformation usersInformation = new UsersInformation("");
        usersInformation.setUsername("Burak");
        usersInformation.setPassword("123");
        System.out.println("Kullanıcı İsmi :" + usersInformation.getUsername());
        System.out.println("Kullanıcı Şifresi :" + usersInformation.getPassword());
    }
    */
    /*
    private static String username;
    private static String password;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        username = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        SpringApplication.run(AuthdemoApplication.class, args);
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
*/
    }
}
