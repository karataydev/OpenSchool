package com.openschool.backend.config;

import com.openschool.backend.models.*;
import com.openschool.backend.repositories.ContentRepository;
import com.openschool.backend.repositories.CourseRepository;
import com.openschool.backend.repositories.RoleRepository;
import com.openschool.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository, UserRepository userRepository,
                                        CourseRepository courseRepository,
                                        ContentRepository contentRepository){
        return args -> {

            Role student = new Role(ERole.ROLE_STUDENT);
            Role tutor = new Role(ERole.ROLE_TUTOR);
            Role admin = new Role(ERole.ROLE_ADMIN);

            roleRepository.saveAll(List.of(student,tutor,admin));


            PasswordEncoder encoder = new BCryptPasswordEncoder();
            User emre = new User(
                    "emrem4rff",
                    "marufemre99@gmail.com",
                    encoder.encode("1221"),
                    "20170702008",
                    "Maruf Emre",
                    "Karatay"
                    );
            Set<Role> roless = new HashSet<>();
            roless.add(student);
            emre.setRoles(roless);
            userRepository.save(emre);
            User selma = new User(
                    "selmakaratay",
                    "selma00000000@gmail.com",
                    encoder.encode("1221"),
                    "000000000001",
                    "Selma",
                    "Karatay"
            );
            Set<Role> roless2 = new HashSet<>();
            roless.add(tutor);
            selma.setRoles(roless);
            userRepository.save(selma);

            Course course1 = new Course();
            course1.setCode("cse111");
            course1.setName("Computer Graphics");
            course1.setTutor(selma);
            course1.setDescription("Bilgisayar dersine hoş geldiniz. Bu derste pek çok şey öğreneceğiz");
            course1.setStudents(List.of(emre));
            courseRepository.save(course1);

            Course course3 = new Course();
            course3.setCode("cse123");
            course3.setName("Deneme Graphics");
            course3.setTutor(selma);
            course3.setDescription("Deneme dersine hoş geldiniz. Bu derste pek çok şey öğreneceğiz");
            course3.setStudents(List.of(selma));
            courseRepository.save(course3);

            Course course2 = new Course();
            course2.setCode("math958");
            course2.setName("Calculus");
            course2.setTutor(selma);
            course2.setDescription("Matemetik dersine hoş geldiniz. Bu derste pek çok şey öğreneceğiz");
            course2.setStudents(List.of(emre));
            courseRepository.save(course2);

            Content content1 = new Content("ödev 1","lorema sdkasuhdas dauısdhasljdjas asudas dasdıyga da dasugdlaasdha", course1,selma);
            contentRepository.save(content1);
            Content content2 = new Content("sınav 2","loraaaajdjas asudas dasdıyga da dasugdlaasdha", course1,selma);
            contentRepository.save(content2);

            Content content3 = new Content("ödev 1","lorema sdkasuhdas dauısdhasljdjas asudas dasdıyga da dasugdlaasdha", course2,selma);
            contentRepository.save(content3);
            Content content4 = new Content("sınav 2","loraaaajdjas asudas dasdıyga da dasugdlaasdha", course2,selma);
            contentRepository.save(content4);

        };
    }
}
