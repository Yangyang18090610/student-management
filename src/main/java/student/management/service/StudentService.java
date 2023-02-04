package student.management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import student.management.entity.Student;
import student.management.form.AuthUpdateForm;
import student.management.form.StudentCreateForm;
import student.management.form.StudentFilterForm;
import student.management.form.StudentUpdateForm;
import student.management.repository.IStudentRepository;
import student.management.specification.SpecificationStudent;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IStudentRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Page<Student> findAll(Pageable pageable, StudentFilterForm form) {
        Specification<Student> studentSpecification = SpecificationStudent.filterStudent(form);
        return repository.findAll(studentSpecification,pageable);
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student findByUserName(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void create(StudentCreateForm form) {
        Student student = mapper.map(form, Student.class);
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        repository.save(student);
    }

    @Override
    public void update(StudentUpdateForm form) {
        Student student = mapper.map(form, Student.class);
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        repository.save(student);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = repository.findByUsername(username);
        if(student == null){
            throw  new UsernameNotFoundException("Can Not found student has username = " + username);
        }
        return new User(
                student.getUsername(),
                student.getPassword(),
                AuthorityUtils.createAuthorityList(student.getRole().toString())
        );
    }
    @Override
    public void updateAuth(AuthUpdateForm form) {
        Student student = repository.findByUsername(form.getUsername());
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        repository.save(student);
    }
}
