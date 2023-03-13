package student.management.form;

import lombok.Getter;
import lombok.Setter;
import student.management.entity.Student;

import java.util.List;


@Getter
@Setter
public class SchoolCreateForm {

    private String name;
    private Integer totalMembers;
    private String type;
//    private List<Student> students;

}
