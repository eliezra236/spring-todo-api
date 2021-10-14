package Eli.ToDoApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ToDoRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new ToDo("Weclome to ToDoApp")));
            log.info("Preloading " + repository.save(new ToDo("<-- Click here to mark checked")));
            log.info("Preloading " + repository.save(new ToDo("Click 'Delete completed to clear the list")));
        };
    }

}
