package graphql.demo.repository;

import graphql.demo.model.Department;
import graphql.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseRepository {

    /**
     * Setting up the Springboot Mongodb starter and setting up the properties as defined in the application.properties
     * will auto define the MongoTemplate bean, which can be used to query the database.
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Employee> findAllEmployees(){
        return mongoTemplate.find(new Query(), Employee.class);
    }

    public List<Department> findAllDepartments(){
        return mongoTemplate.find(new Query(), Department.class);
    }

    public Employee findEmployeeById(String id){
        return mongoTemplate.find(new Query(Criteria.where("guid").is(id)), Employee.class).stream().findFirst().orElse(null);
    }

    public List<Employee> findEmployeeByDepartmentId(String id){
        return mongoTemplate.find(new Query(Criteria.where("department").is(id)), Employee.class);
    }

    public Department findDepartmentById(String id){
        return mongoTemplate.find(new Query(Criteria.where("guid").is(id)), Department.class).stream().findFirst().orElse(null);
    }

    public Department findDepartmentByName(String name){
        return mongoTemplate.find(new Query(Criteria.where("name").is(name)), Department.class).stream().findFirst().orElse(null);
    }

    public Employee findEmployeeByName(String name){
        return mongoTemplate.find(new Query(Criteria.where("name").is(name)), Employee.class).stream().findFirst().orElse(null);
    }

    public void cleanDb(){
        mongoTemplate.remove(new Query(), Employee.class);
        mongoTemplate.remove(new Query(), Department.class);
    }

    public void addDepartments(List<Department> departmentList){
        departmentList.forEach(department -> {mongoTemplate.save(department);});
    }

    public void addEmployees(List<Employee> employeeList){
        employeeList.forEach(employee -> {mongoTemplate.save(employee);});
    }
}
