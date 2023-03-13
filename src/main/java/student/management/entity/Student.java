package student.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 50, unique = true,nullable = false,updatable = false )
    private String username;

    @Column(name = "password",length = 72, nullable = false)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Formula(value = "concat_ws(' ', first_name,last_name)")
    private String fullName;

    @Column(name = "gender", length = 6, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

//    @Column(name = "address")
//    private String address;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
//
//    @Column(name = "updated_at",nullable = false)
//    @UpdateTimestamp
//    private Date updatedAt;

    @Column(name = "role", length = 7, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    private School school  ;
    public enum Role {
            ADMIN, MANAGER,STUDENT
    }
    public enum Gender {
        MALE,FEMALE
    }


}
