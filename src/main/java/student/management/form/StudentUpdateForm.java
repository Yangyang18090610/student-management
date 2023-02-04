package student.management.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentUpdateForm {
    private Integer id;
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
