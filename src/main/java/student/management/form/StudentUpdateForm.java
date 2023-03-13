package student.management.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class StudentUpdateForm {
    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String role;
    private Date dateOfBirth;
    private Number numberPhone;
    private Integer schoolId;

}
