package fr.joand.supermarket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!test")
@Service
public class ApplicationRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("compute basket price");
    }

}
