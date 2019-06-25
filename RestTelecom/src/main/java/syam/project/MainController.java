package syam.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syam.project.CustomResponse.Root;
import syam.project.CustomValidation.ValidationRequest;
import syam.project.OutboundRestProduct.InvokeRestProduct;
import syam.project.OutboundRestProduct.ProductPojo;
import syam.project.OutboundSoapAuthentication.InvokeAuth;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement
@RestController
public class MainController {

    @Autowired
    CustomerRepository CustomerRepo;

    public CustomerRepository getCustomerRepo() {
        return CustomerRepo;
    }

    public void setCustomerRepo(CustomerRepository customerRepo) {
        CustomerRepo = customerRepo;
    }

    @GetMapping(value = "/syam")
    public String testPage() {
        return "This is syam project index page";
    }

//========================================================//
//================= Customer By Param ====================//
//========================================================//
//======= GET, POST, PUT, DELETE BY USING PARAM ==========//
//========================================================//

    @GetMapping(path = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> searchCustomerByParam
            (@RequestParam(required = false)
                     String id, String name, String identityNumber, String startDate, String endDate, String pageNo, String pageRow, String sortBy
            ,@RequestHeader
                     String authorization) {

        Long l= new Long(10);
        CommonFunction CF = new CommonFunction();
        Pageable paging = new PageRequest(CF.getPN(pageNo), CF.getPR(pageRow));
        Root ResponseLV0 = new Root();
        InvokeAuth auth = new InvokeAuth();

        String authResult = auth.InvokeAuthGetResult("","",authorization);

        if (authResult.equals("valid"))
        {


                if (id != null)
                {
                    int customerId = Integer.parseInt(id);
                    Object Body = CustomerRepo.findOne(customerId);
                    ResponseLV0.setResponseBody(Body);
                    ResponseLV0.setResponseHeader(0,0,0,0,0);
                    return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
                }
                else if (name != null && identityNumber==null)
                {
                    Page<List<Customer>> customers  = CustomerRepo.findByNameContaining(name, paging);
                    Object Body =  customers.getContent();
                    l = customers.getTotalElements();
                    int i = l.intValue();
                    ResponseLV0.setResponseBody(Body);
                    ResponseLV0.setResponseHeader(
                            0,
                            customers.getNumber(),
                            customers.getSize(),
                            customers.getTotalPages(), i);
                    return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
                }
                else if (name !=null && identityNumber != null){
                    Page<List<Customer>> customers = CustomerRepo.findByNameContainingOrIdentityNumberContaining(name,identityNumber,paging);
                    Object Body =  customers.getContent();

                    l = customers.getTotalElements();
                    int i = l.intValue();
                    ResponseLV0.setResponseBody(Body);
                    ResponseLV0.setResponseHeader(
                            0,
                            customers.getNumber(),
                            customers.getSize(),
                            customers.getTotalPages(), i);
                    return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
                }
                else if (startDate != null){

                    ValidationRequest VR = new ValidationRequest();
                    int x = VR.ValCustomerDate(startDate,endDate);
                    if (x==0)
                    {
                        Page<List<Customer>> customers = CustomerRepo.findByJoinedDateBetween(startDate, endDate, paging);
                        Object Body = customers.getContent();
                        l = customers.getTotalElements();
                        int i = l.intValue();
                        ResponseLV0.setResponseBody(Body);
                        ResponseLV0.setResponseHeader(
                                x,
                                customers.getNumber(),
                                customers.getSize(),
                                customers.getTotalPages(), i);
                        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
                    }
                    else
                    {
                        ResponseLV0.setResponseHeader(
                                x, 0,0,0,0);
                        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
                    }


                }
                else
                {

                    Page<List<Customer>> customers =  CustomerRepo.findByJoinedDateBetween("1800-01-01 00:00:00","3000-12-31 00:00:00", paging);
                    Object Body =  customers.getContent();
                    l = customers.getTotalElements();
                    int i = l.intValue();
                    ResponseLV0.setResponseHeader(
                            0,
                            customers.getNumber(),
                            customers.getSize(),
                            customers.getTotalPages(), i);
                    ResponseLV0.setResponseBody(Body);
                    return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
                }
        }
        else

            ResponseLV0.setResponseHeader(100,0,0,0,0);
            return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
    }


    @PostMapping(path = "/customer/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> createCustomerByParam(@RequestParam String name, String address, String identityType, String identityNumber, String joinDate, String requestedBy){
        CustomerRepo.save(new Customer(name, address, identityType, identityNumber, joinDate, requestedBy));
        Root ResponseLV0 = new Root();
        ResponseLV0.setResponseHeader(0,0,0,0,0);
        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
    }

    @PutMapping(path = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> updateCustomerByParam(@RequestParam String id, String name, String address, String identityType, String identityNumber, String joinDate, String requestedBy)
    {
        Integer i = Integer.parseInt(id);
        Customer cust = CustomerRepo.findOne(i);
        if (name!=null) { cust.setName(name); }
        if (address!=null) {cust.setAddress(address);}
        if (identityType!=null) { cust.setIdentityType(identityType);}
        if (identityNumber!=null) {cust.setIdentityNumber(identityNumber);}
        if (joinDate!=null) {cust.setJoinedDate(joinDate);}
        if (requestedBy!=null) {cust.setUpdatedBy(requestedBy);}

        CustomerRepo.save(cust);
        Root ResponseLV0 = new Root();
        ResponseLV0.setResponseHeader(0,0,0,0,0);
        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
    }

    @DeleteMapping(path = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> deleteCustomerByParam(@RequestParam String id){
        int i = Integer.parseInt(id);
        CustomerRepo.delete(i);
        Root ResponseLV0 = new Root();
        ResponseLV0.setResponseHeader(0,0,0,0,0);
        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
    }

//========================================================//
//================= Customer By Body =====================//
//========================================================//
//======= GET, POST, PUT, DELETE BY USING BODY ===========//
//========================================================//

    @PostMapping(path = "/customer/v2/search", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> searchCustomerByBody (@RequestBody Map<String, String>  RB)
    {
        String id = RB.get("id");
        String name = RB.get("name");
        String identityNumber = RB.get("identityNumber");
        String startDate = RB.get("startDate");
        String endDate = RB.get("endDate");
        String sortBy = RB.get("sortBy");
        String pageNo = RB.get("pageNo");
        String pageRow = RB.get("pageRow");

        if (id != null)
        {
            int customerId = Integer.parseInt(id);
            Object Body = CustomerRepo.findOne(customerId);
            Root ResponseLV0 = new Root();
            ResponseLV0.setResponseBody(Body);
            ResponseLV0.setResponseHeader(0,0,0,0,0);
            return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
        }
        else if (name != null && identityNumber==null){
            CommonFunction CF = new CommonFunction();
            Pageable paging = new PageRequest(CF.getPN(pageNo), CF.getPR(pageRow));
            Page<List<Customer>> customers  = CustomerRepo.findByNameContaining(name, paging);
            Object Body =  customers.getContent();
            Root ResponseLV0 = new Root();
            Long l= new Long(10);
            l = customers.getTotalElements();
            int i = l.intValue();
            ResponseLV0.setResponseBody(Body);
            ResponseLV0.setResponseHeader(
                    0,
                    customers.getNumber(),
                    customers.getSize(),
                    customers.getTotalPages(), i);
            return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
        }
        else if (name !=null && identityNumber != null){
            CommonFunction CF = new CommonFunction();
            Pageable paging = new PageRequest(CF.getPN(pageNo), CF.getPR(pageRow));
            Page<List<Customer>> customers = CustomerRepo.findByNameContainingOrIdentityNumberContaining(name,identityNumber,paging);
            Object Body =  customers.getContent();
            Root ResponseLV0 = new Root();
            Long l= new Long(10);
            l = customers.getTotalElements();
            int i = l.intValue();
            ResponseLV0.setResponseBody(Body);
            ResponseLV0.setResponseHeader(
                    0,
                    customers.getNumber(),
                    customers.getSize(),
                    customers.getTotalPages(), i);
            return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
        }
        else if (startDate != null){

            CommonFunction CF = new CommonFunction();
            Pageable paging = new PageRequest(CF.getPN(pageNo), CF.getPR(pageRow));
            Page<List<Customer>> customers = CustomerRepo.findByJoinedDateBetween(startDate,endDate, paging);
            Object Body =  customers.getContent();
            Root ResponseLV0 = new Root();
            Long l= new Long(10);
            l = customers.getTotalElements();
            int i = l.intValue();
            ResponseLV0.setResponseBody(Body);
            ResponseLV0.setResponseHeader(
                    0,
                    customers.getNumber(),
                    customers.getSize(),
                    customers.getTotalPages(), i);
            return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
        }
        else
        {
            CommonFunction CF = new CommonFunction();
            Pageable paging = new PageRequest(CF.getPN(pageNo), CF.getPR(pageRow));
            Page<List<Customer>> customers =  CustomerRepo.findByJoinedDateBetween("1800-01-01 00:00:00","3000-12-31 00:00:00", paging);
            Object Body =  customers.getContent();
            Root ResponseLV0 = new Root();
            Long l= new Long(10);
            l = customers.getTotalElements();
            int i = l.intValue();
            ResponseLV0.setResponseHeader(
                    0,
                    customers.getNumber(),
                    customers.getSize(),
                    customers.getTotalPages(), i);
            ResponseLV0.setResponseBody(Body);
            return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/customer/v2", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> createCustomerByBody(@RequestBody Map<String,String>RB){

        String name = RB.get("name");
        String identityNumber = RB.get("identityNumber");
        String address = RB.get("startDate");
        String identityType = RB.get("endDate");
        String joinDate = RB.get("sortBy");
        String requestedBy = RB.get("pageNo");

        CustomerRepo.save(new Customer(name, address, identityType, identityNumber, joinDate, requestedBy));
        Root ResponseLV0 = new Root();
        ResponseLV0.setResponseHeader(0,0,0,0,0);
        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
    }

    @PutMapping(path = "/customer/v2", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> updateCustomerByBody(@RequestBody Map<String,String>RB){

        String id = RB.get("id");
        String name = RB.get("name");
        String identityNumber = RB.get("identityNumber");
        String address = RB.get("startDate");
        String identityType = RB.get("endDate");
        String joinDate = RB.get("sortBy");
        String requestedBy = RB.get("pageNo");

        Integer i = Integer.parseInt(id);
        Customer cust = CustomerRepo.findOne(i);
        if (name!=null){cust.setName(name);}
        if (address!=null){cust.setAddress(address);}
        if (identityType!=null){cust.setIdentityType(identityType);}
        if (identityNumber!=null){cust.setIdentityNumber(identityNumber);}
        if (joinDate!=null){cust.setJoinedDate(joinDate);}
        if (requestedBy!=null){cust.setUpdatedBy(requestedBy);}
        CustomerRepo.save(cust);
        Root ResponseLV0 = new Root();
        ResponseLV0.setResponseHeader(0,0,0,0,0);
        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
    }

    @DeleteMapping(path = "/customer/v2", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> deleteCustomerByBody(@RequestBody Map<String,String>RB){

        String id = RB.get("id");
        int i = Integer.parseInt(id);
        CustomerRepo.delete(i);
        Root ResponseLV0 = new Root();
        ResponseLV0.setResponseHeader(0,0,0,0,0);
        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);
    }

    //===============product============//
    @GetMapping(path = "/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Root> searchProduct
    (@RequestParam(required = false)
             String id, String name, String identityNumber, String startDate, String endDate, String pageNo, String pageRow, String sortBy
            )
    {
        InvokeRestProduct IRP = new InvokeRestProduct();
        ProductPojo product = IRP.InvokeRestProduct();
        Root ResponseLV0 = new Root();
        ResponseLV0.setResponseBody(product.getBody());
        ResponseLV0.setResponseHeader(0,0,0,0,0);
        return new ResponseEntity<Root>(ResponseLV0, HttpStatus.OK);


    }
}
