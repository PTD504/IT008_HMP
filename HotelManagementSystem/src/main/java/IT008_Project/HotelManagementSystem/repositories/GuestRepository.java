package IT008_Project.HotelManagementSystem.repositories;

import IT008_Project.HotelManagementSystem.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> { 
    public Guest  findByIdentityCard(String identityCard);
}
