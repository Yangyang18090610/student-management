package student.management.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SchoolCreateForm {

    private String name;
    private Integer totalMembers;
    private String type;
    private List<Student> students;

    @Getter
    @Setter
    public static class Student{
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String role;
    }
}
