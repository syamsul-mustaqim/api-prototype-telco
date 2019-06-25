package syam.project.OutboundRestProduct;

import org.springframework.web.client.RestTemplate;

public class InvokeRestProduct {

    public ProductPojo  InvokeRestProduct(){
        RestTemplate RT = new RestTemplate();
        ProductPojo product = RT.getForObject("http://localhost:8089/test/product/", ProductPojo.class);
        return product;
    }
}
