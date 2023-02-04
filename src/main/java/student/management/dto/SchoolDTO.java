package student.management.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import student.management.entity.School.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class SchoolDTO {
    private Integer id;
    private String name;
    private Integer totalMembers;
    private Type type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    private List<StudentDTO> students;

    @Setter
    @Getter
    public static class StudentDTO {
        @JsonProperty("accountid")
        private Integer id;
        private String username;
    }
}
