package IT008_Project.HotelManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IT008_Project.HotelManagementSystem.models.Payment;
@Repository 
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    
} 
