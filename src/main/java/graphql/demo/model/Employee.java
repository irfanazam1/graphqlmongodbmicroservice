package graphql.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

@Data
@With
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    protected String guid;
    protected String name;
    protected String address;
    protected String department;
}
