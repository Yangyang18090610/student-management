package student.management.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "school")
public class School {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "total_members", nullable = false, updatable = true)
    private Integer totalMembers;

    @Column(name= "type", length = 7, nullable = false)
    @Enumerated(value = EnumType.STRING )
    private Type type;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "school",cascade = CascadeType.ALL)
    private List<Student> students;
    public enum Type{
        FRESHER,JUNIOR,SENIOR
    }

}
