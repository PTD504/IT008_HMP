package IT008_Project.HotelManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IT008_Project.HotelManagementSystem.models.RoomTypes;

@Repository
public interface RoomTypesRepository  extends JpaRepository<RoomTypes, Integer>{ 


}
