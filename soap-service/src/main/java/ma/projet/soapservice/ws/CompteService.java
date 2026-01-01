package ma.projet.soapservice.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import ma.projet.soapservice.entity.Compte;
import ma.projet.soapservice.entity.TypeCompte;
import ma.projet.soapservice.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Service Web SOAP pour la gestion des comptes
 */
@Component
@WebService(serviceName = "CompteWS")
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    @WebMethod(operationName = "getComptes")
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    @WebMethod(operationName = "getCompteById")
    public Compte getCompteById(@WebParam(name = "id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @WebMethod(operationName = "createCompte")
    public Compte createCompte(@WebParam(name = "solde") Double solde, @WebParam(name = "type") String type) {
        try {
            TypeCompte typeCompte = TypeCompte.valueOf(type.toUpperCase());
            Compte compte = new Compte(solde, typeCompte);
            return compteRepository.save(compte);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @WebMethod(operationName = "updateCompte")
    public boolean updateCompte(@WebParam(name = "id") Long id, @WebParam(name = "solde") Double solde,
            @WebParam(name = "type") String type) {
        try {
            Compte compte = compteRepository.findById(id).orElse(null);
            if (compte == null)
                return false;
            compte.setSolde(solde);
            compte.setType(TypeCompte.valueOf(type.toUpperCase()));
            compteRepository.save(compte);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @WebMethod(operationName = "deleteCompte")
    public boolean deleteCompte(@WebParam(name = "id") Long id) {
        try {
            if (compteRepository.existsById(id)) {
                compteRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @WebMethod(operationName = "getComptesByType")
    public List<Compte> getComptesByType(@WebParam(name = "type") String type) {
        try {
            TypeCompte typeCompte = TypeCompte.valueOf(type.toUpperCase());
            return compteRepository.findByType(typeCompte);
        } catch (IllegalArgumentException e) {
            return List.of();
        }
    }
}
