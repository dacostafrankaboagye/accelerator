package frank.productmanagerapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupMessage implements CommandLineRunner {

    @Value("${welcome.defaultMessage}")
    private String productManagerApiWelcomeMessage;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Displaying a welcome message on startup using application.properties: \n" + productManagerApiWelcomeMessage);

    }
}
