package IT008_Project.HotelManagementSystem.repositories;

import IT008_Project.HotelManagementSystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
