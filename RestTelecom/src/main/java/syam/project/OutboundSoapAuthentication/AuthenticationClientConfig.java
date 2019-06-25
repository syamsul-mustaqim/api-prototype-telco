package syam.project.OutboundSoapAuthentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class AuthenticationClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("syam.project.authentication");
        return marshaller;
    }

    @Bean
    public AuthenticationClient authenticationClient(Jaxb2Marshaller marshaller) {
        AuthenticationClient client = new AuthenticationClient();
        client.setDefaultUri("http://localhost:8088/authentication/?WSDL&interface=Authentication_bind&part=Authentication.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}