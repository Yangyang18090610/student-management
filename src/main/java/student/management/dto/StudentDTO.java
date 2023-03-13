package student.management.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String role;
    private String userName;
    private String fullName;
    private String schoolName;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
//    private String address;
    private String numberPhone;
}
