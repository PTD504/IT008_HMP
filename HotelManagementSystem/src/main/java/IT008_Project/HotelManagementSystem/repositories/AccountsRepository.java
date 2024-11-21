package IT008_Project.HotelManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IT008_Project.HotelManagementSystem.models.Accounts;
import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> { 
    public Accounts findByUserName(String userName);

}
