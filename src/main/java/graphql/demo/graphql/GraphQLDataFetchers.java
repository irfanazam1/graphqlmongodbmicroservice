package graphql.demo.graphql;

import graphql.demo.model.Employee;
import graphql.demo.repository.DatabaseRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLDataFetchers {
    @Autowired
    private DatabaseRepository databaseRepository;

    public DataFetcher findAllEmployees(){
        return dataFetchingEnvironment -> {
            return databaseRepository.findAllEmployees();
        };
    }

    public DataFetcher findEmployeeById(){
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("guid");
            return databaseRepository.findEmployeeById(id);
        };
    }

    public  DataFetcher findEmployeeByDepartment(){
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("department");
            return databaseRepository.findEmployeeByDepartmentId (id);
        };
    }

    public DataFetcher findAllDepartments(){
        return dataFetchingEnvironment -> {
            return databaseRepository.findAllDepartments();
        };
    }

    public DataFetcher findDepartmentByName(){
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            return databaseRepository.findDepartmentByName(name);
        };
    }

    public DataFetcher findEmployeeByName(){
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            return databaseRepository.findEmployeeByName(name);
        };
    }


    public DataFetcher getDepartment(){
        return dataFetchingEnvironment -> {
            Employee employee = dataFetchingEnvironment.getSource();
            return databaseRepository.findDepartmentById(employee.getDepartment());
        };
    }
}