package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        taskRepository.saveAll(List.of(
            new Task("Thur","São Paulo", "20/08/04", "40215847569", "11989550574"),
            new Task("Gui","São Paulo", "20/08/00", "40215847569", "11989550574"),
            new Task("May","São Paulo", "20/08/96", "40215847569", "11989550574"),
            new Task("Day","São Paulo", "20/08/96", "40215847569", "11989550574"),
            new Task("Leo","São Paulo", "20/08/92", "40215847589", "11989550574"),
            new Task("Gabril","São Paulo", "20/08/92", "40215847569", "11989550574"),
            new Task("Nat","São Paulo", "20/08/93", "40215847569", "11989550574")


           
        ));

        userRepository.save(
            new User()
                .name("Gui")
                .email("gui@fiap.com.br")
                .password(passwordEncoder.encode("123"))
        );
        
    }
    
}
