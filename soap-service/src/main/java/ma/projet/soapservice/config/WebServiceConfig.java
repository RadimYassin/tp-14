package ma.projet.soapservice.config;

import jakarta.xml.ws.Endpoint;
import ma.projet.soapservice.ws.CompteService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration du service web SOAP
 */
@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private CompteService compteService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, compteService);
        endpoint.publish("/ws");
        return endpoint;
    }
}
