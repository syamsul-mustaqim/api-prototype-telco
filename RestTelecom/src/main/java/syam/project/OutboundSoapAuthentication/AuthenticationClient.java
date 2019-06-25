package syam.project.OutboundSoapAuthentication;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import syam.project.authentication.Input;
import syam.project.authentication.Input.Body;
import syam.project.authentication.Output;

public class AuthenticationClient extends WebServiceGatewaySupport {

    public Output getAuth(String username, String password, String token) {
        Input request = new Input();
        Body a = new Body();
        a.setUsername(username);
        a.setPassword(password);
        a.setToken(token);
        request.setBody(a);
        return (Output) getWebServiceTemplate().marshalSendAndReceive(request);
    }

}