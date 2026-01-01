package ma.projet.soapservice.config;

import ma.projet.soapservice.entity.Compte;
import ma.projet.soapservice.entity.TypeCompte;
import ma.projet.soapservice.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Initialisation des données de test
 */
@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(CompteRepository repository) {
        return args -> {
            repository.save(new Compte(2000.0, TypeCompte.COURANT));
            repository.save(new Compte(30007.0, TypeCompte.COURANT));
            repository.save(new Compte(45999.688, TypeCompte.EPARGNE));
        };
    }
}
