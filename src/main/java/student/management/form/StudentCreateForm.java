package student.management.form;

import lombok.Getter;
import lombok.Setter;
import student.management.entity.Student;

import java.time.LocalDate;

@Getter
@Setter
public class StudentCreateForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String role;
    private LocalDate dateOfBirth;
    private String address;
    private Number numberPhone;
    private Integer schoolId;

}
