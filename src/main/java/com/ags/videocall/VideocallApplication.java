package com.ags.videocall;

import com.ags.videocall.user.User;
import com.ags.videocall.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideocallApplication.class, args);}

    @Bean
    public CommandLineRunner commandLineRunner(
            UserService userService
    ){
        return args -> {
            userService.register(User.builder().username("Ags").email("agsschulze@gmail.com").password("Root123").build());
            userService.register(User.builder().username("Jvidal").email("jvidal@gmail.com").password("Root123").build());
            userService.register(User.builder().username("Ddries").email("ddries@gmail.com").password("Root123").build());

        };
    }

}
