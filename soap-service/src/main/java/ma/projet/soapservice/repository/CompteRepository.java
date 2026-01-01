package ma.projet.soapservice.repository;

import ma.projet.soapservice.entity.Compte;
import ma.projet.soapservice.entity.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository pour les comptes
 */
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByType(TypeCompte type);

    List<Compte> findBySoldeGreaterThan(Double solde);
}
