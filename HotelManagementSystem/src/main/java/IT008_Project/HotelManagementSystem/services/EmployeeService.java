package IT008_Project.HotelManagementSystem.services;

import IT008_Project.HotelManagementSystem.models.Employee;
import IT008_Project.HotelManagementSystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getEmployeeList() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repo.findById(id).get();
    }

    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        repo.delete(employee);
    }
}
