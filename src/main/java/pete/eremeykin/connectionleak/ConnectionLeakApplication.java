package pete.eremeykin.connectionleak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionLeakApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectionLeakApplication.class, args);
    }

}
