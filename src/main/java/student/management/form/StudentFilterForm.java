package student.management.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentFilterForm {

    private String search;
    private Integer minId;
    private Integer maxId;
}
