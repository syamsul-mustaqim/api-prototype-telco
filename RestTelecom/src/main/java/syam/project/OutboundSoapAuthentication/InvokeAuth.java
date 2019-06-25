package syam.project.OutboundSoapAuthentication;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import syam.project.authentication.Output;
public class InvokeAuth {

    public String InvokeAuthGetResult(String username, String password, String token) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AuthenticationClientConfig.class);
        AuthenticationClient client = context.getBean(AuthenticationClient.class);
        Output response = client.getAuth(username, password, token);
        return response.getBody().getResult();
    }}