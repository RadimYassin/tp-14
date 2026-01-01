package ma.projet.soapservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application SOAP Service
 */
@SpringBootApplication
public class SoapServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoapServiceApplication.class, args);
        System.out.println("Service SOAP démarré sur http://localhost:8082/services/ws");
    }
}
