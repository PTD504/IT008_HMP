package IT008_Project.HotelManagementSystem.dtos;

import java.sql.Date;

public class PaymentCreationRequest {
    private int bookingId;
    private int employeeId;
    private int payAmount;
    private Date payDate;
    private String payMethod;

    public PaymentCreationRequest()
    {

    } 
    public PaymentCreationRequest(int bookingId, int employeeId, int payAmount, Date payDate, String payMethod)
    {
        this.bookingId=bookingId;
        this.employeeId=employeeId;
        this.payAmount=payAmount;
        this.payDate= payDate;
        this.payMethod=payMethod;
    }
    
    public int getBookingId() 
    {
        return this.bookingId;
    }
    public int getEmployeeId() 
    {
        return this.employeeId;
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
