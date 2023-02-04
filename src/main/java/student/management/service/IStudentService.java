package student.management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import student.management.entity.Student;
import student.management.form.AuthUpdateForm;
import student.management.form.StudentCreateForm;
import student.management.form.StudentFilterForm;
import student.management.form.StudentUpdateForm;

import java.util.List;

public interface IStudentService extends UserDetailsService  {
    Page<Student> findAll(Pageable pageable, StudentFilterForm form);

    Student findById(int id);

    Student findByUserName(String username);

    void create(StudentCreateForm form);

    void update(StudentUpdateForm form);

    void deleteAllById(List<Integer> ids);

    void updateAuth(AuthUpdateForm form);

}
