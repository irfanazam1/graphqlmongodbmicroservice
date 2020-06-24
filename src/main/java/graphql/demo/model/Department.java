package graphql.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@With
@RequiredArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    protected String guid;
    protected String name;
    protected String description;
}
