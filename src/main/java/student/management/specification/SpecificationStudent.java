package student.management.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import student.management.entity.Student;
import student.management.form.StudentFilterForm;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

public class SpecificationStudent {
    public static Specification<Student>filterStudent(StudentFilterForm form) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%" + form.getSearch().trim() + "%";
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("username"), pattern),
                        criteriaBuilder.like(root.get("school").get("name"), pattern)
                        ));
            }
            if (form.getMinId()!= null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("id"),form.getMinId()));
            }
            if (form.getMaxId()!= null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("id"),form.getMaxId()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
