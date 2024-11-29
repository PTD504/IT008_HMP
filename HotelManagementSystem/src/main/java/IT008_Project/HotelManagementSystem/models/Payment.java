package IT008_Project.HotelManagementSystem.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.experimental.FieldNameConstants;

@Entity
@FieldNameConstants
@Table(name="payments")
public class Payment { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="payment_id", columnDefinition = "INT") 
    private int paymentId;

    @ManyToOne
    @JoinColumn(name="booking_id", columnDefinition = "INT", referencedColumnName = "booking_id")
    private Bookings booking;

    @ManyToOne
    @JoinColumn(name="employee_id", columnDefinition = "INT", referencedColumnName = "employee_id") 
    private Employee employee;

    @Column(name="pay_amount", columnDefinition = "INT") 
    private int payAmount;

    @Column(name="pay_date", columnDefinition = "DATE") 
    private Date payDate;

    @Column(name="pay_method", columnDefinition = "NVARCHAR(50)") 
    private String payMethod;

    public Payment() 
    {

    } 
    public Payment(int paymentId, Bookings booking, Employee employee, int payAmount, Date payDate, String payMethod) 
    {
        this.paymentId=paymentId;
        this.booking=booking;
        this.employee=employee;
        this.payDate= payDate;
        this.payMethod=payMethod;
    }

    public int getPaymentId() 
    {
        return this.paymentId;
    } 
    public Bookings getBooking() 
    {
        return this.booking;    
    }
    public Employee getEmployee()
    {
        return this.employee;
    }
    public int getPayAmount() 
    {
        return this.payAmount;
    }
    public Date getPayDate() 
    {
        return this.payDate;   
    }
    public String getPayMethod() 
    {
        return this.payMethod; 
    }

}
