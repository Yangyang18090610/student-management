package student.management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import student.management.entity.School;
import student.management.entity.Student;
import student.management.form.SchoolCreateForm;
import student.management.form.SchoolFilterForm;
import student.management.form.SchoolUpdateForm;
import student.management.repository.ISchoolRepository;
import student.management.specification.SpecificationSchool;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ISchoolRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Page<School> findAll(Pageable pageable, SchoolFilterForm form) {
        Specification<School> specification = SpecificationSchool.filterClass(form);
        return repository.findAll(specification,pageable);
    }

    @Override
    public School findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(SchoolCreateForm form) {
        School school = mapper.map(form, School.class);
        List<Student> students = school.getStudents();
        if (!students.isEmpty()) {
            for (Student student : students) {
                student.setSchool(school);
                String encodedPassword = passwordEncoder.encode(student.getPassword());
                student.setPassword(encodedPassword);
            }
        }
        repository.save(school);
    }

    @Override
    public void update(SchoolUpdateForm form) {
        School school = mapper.map(form, School.class);
        repository.save(school);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
