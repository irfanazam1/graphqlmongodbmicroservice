package graphql.demo;

import graphql.demo.model.Department;
import graphql.demo.model.Employee;
import graphql.demo.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	DatabaseRepository databaseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	void setupDB(){
		databaseRepository.cleanDb();
		Department department = new Department();
		department.setName("Automation");
		department.setDescription("Test Automation");
		List<Department> departmentList = new ArrayList<>();
		departmentList.add(department);
		databaseRepository.addDepartments(departmentList);

		List<Employee> employeeList = new ArrayList<>();

		Employee employee = new Employee();
		employee.setName("Test 1");
		employee.setAddress("Austin, TX");
		employee.setDepartment(department.getGuid());
		employeeList.add(employee);

		employee = new Employee();
		employee.setName("Test 2");
		employee.setAddress("Dallas, TX");
		employee.setDepartment(department.getGuid());
		employeeList.add(employee);

		databaseRepository.addEmployees(employeeList);

	}

}
