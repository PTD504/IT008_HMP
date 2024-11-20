package IT008_Project.HotelManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.experimental.FieldNameConstants;

@Entity 
@FieldNameConstants 
@Table(name="ad_services")
public class Service { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="service_id", columnDefinition="INT") 
    private int serviceId;

    @Column(name="service_description", columnDefinition = "NVARCHAR(100)") 
    private String serviceDescription;

    @Column(name="service_price", columnDefinition = "INT") 
    private int servicePrice;

    public Service() 
    { 

    } 
    public Service(int serviceId, String serviceDescription, int servicePrice) 
    { 
        this.serviceId= serviceId; 
        this.serviceDescription=serviceDescription; 
        this.servicePrice=servicePrice;
    } 
    public int getServiceId(){ 
        return this.serviceId;
    } 
    public String getServiceDeescription() 
    { 
        return this.serviceDescription;
    } 
    public int getServicePrice() 
    {
        return this.servicePrice;
    }
    public void setServiceDescription(String serviceDescription) 
    {
        this.serviceDescription=serviceDescription;
    } 
    public void setServicePice(int servicePrice) 
    {
        this.servicePrice= servicePrice;
    }


}
