package IT008_Project.HotelManagementSystem.services;

import IT008_Project.HotelManagementSystem.models.Guest;
import IT008_Project.HotelManagementSystem.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository repo;

    public List<Guest> getGuestList() {
        return repo.findAll();
    }

    public Guest getGuestById(int id) {
        return repo.findById(id).get();
    }

    public Guest saveGuest(Guest guest) {
        return repo.save(guest);
    }

    public void deleteGuest(Guest guest) {
        repo.delete(guest);
    }

}
