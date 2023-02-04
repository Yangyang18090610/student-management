package student.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String role;
    private String username;
    private String fullName;
    private String schoolName;
    private String gender;
    private LocalDate dateOfBirth;
    private String address;
    private Number numberPhone;
}
