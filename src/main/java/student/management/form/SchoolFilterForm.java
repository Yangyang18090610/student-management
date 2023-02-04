package student.management.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import student.management.entity.School;
import java.time.LocalDateTime;

@Getter
@Setter
public class SchoolFilterForm {
    private String search;
    private Integer minTotalMembers;
    private Integer maxTotalMembers;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime minCreatedAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime maxCreatedAt;

    private School.Type type;
}
