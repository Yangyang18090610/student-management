package student.management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import student.management.entity.School;
import student.management.form.SchoolCreateForm;
import student.management.form.SchoolFilterForm;
import student.management.form.SchoolUpdateForm;

import java.util.List;

public interface ISchoolService {

    Page<School> findAll(Pageable pageable, SchoolFilterForm form);

    School findById(int id);

    void create(SchoolCreateForm form);

    void update(SchoolUpdateForm form);

    void deleteAllById(List<Integer> ids);

}
