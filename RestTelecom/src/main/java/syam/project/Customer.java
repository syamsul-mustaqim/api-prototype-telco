package syam.project;


import org.hibernate.annotations.common.reflection.java.generics.IdentityTypeEnvironment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@XmlRootElement
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String identityType;
    private String identityNumber;
    private String joinedDate;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Customer (){

    }

    public Customer (String Name, String Identity_Number){
        this.setName((Name));
        this.setIdentityNumber(Identity_Number);
    }

    public Customer(int id, String Name, String Identity_Number) {
        this.setId(id);
        this.setName((Name));
        this.setIdentityNumber(Identity_Number);
    }

    public  Customer(String name, String address, String identityType, String identityNumber, String joinDate, String requestedBy) {
        this.setName(name);
        this.setAddress(address);
        this.setIdentityType(identityType);
        this.setIdentityNumber(identityNumber);
        this.setJoinedDate(joinDate);
        this.setCreatedBy(requestedBy);

    }


}
