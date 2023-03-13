package student.management.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Setter
@Getter
public class StudentFilterForm {

    private String search;
    private Integer minId;
    private Integer maxId;

}
