package student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import student.management.entity.School;

public interface ISchoolRepository extends JpaRepository<School, Integer>, JpaSpecificationExecutor<School> {

}
