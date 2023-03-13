package student.management.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import student.management.entity.Student;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class StudentCreateForm {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String role;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
//    private String address;
    private String numberPhone;
    private Integer schoolId;

}
