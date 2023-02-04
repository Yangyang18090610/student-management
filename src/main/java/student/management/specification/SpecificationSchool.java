package student.management.specification;

import org.springframework.data.jpa.domain.Specification;
import student.management.entity.School;
import student.management.form.SchoolFilterForm;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SpecificationSchool {
    public static Specification<School> filterClass(SchoolFilterForm form) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
//            query.distinct(true);
            if (form.getSearch() != null && !form.getSearch().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + form.getSearch()));
            }
            if (form.getType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("type"), "%" + form.getType()));
            }
            if (form.getMinTotalMembers() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("totalMembers"),form.getMinTotalMembers()));
            }
            if (form.getMaxTotalMembers() !=null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalMembers"),form.getMaxTotalMembers()));
            }
            if (form.getMaxCreatedAt() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"),form.getMaxCreatedAt()));
            }
            if (form.getMinCreatedAt() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"),form.getMinCreatedAt()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
