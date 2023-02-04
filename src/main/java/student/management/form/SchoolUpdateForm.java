package student.management.form;

import lombok.Getter;
import lombok.Setter;
import student.management.entity.School;


@Getter
@Setter
public class SchoolUpdateForm {
    private Integer id;
    private String name;
    private Integer totalMembers;
    private School.Type type;
}
