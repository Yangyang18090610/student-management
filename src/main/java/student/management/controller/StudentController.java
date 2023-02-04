package student.management.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import student.management.dto.StudentDTO;
import student.management.entity.Student;
import student.management.form.StudentCreateForm;
import student.management.form.StudentFilterForm;
import student.management.form.StudentUpdateForm;
import student.management.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IStudentService service;

    @GetMapping
    public Page<StudentDTO> findAll (Pageable pageable, StudentFilterForm form){
        Page<Student> page = service.findAll(pageable, form);
        List<Student> students = page.getContent();
        List<StudentDTO>dtos = mapper.map(students,
                new TypeToken<List<StudentDTO>>(){}.getType());
        return new PageImpl<>(dtos,pageable,page.getTotalElements());
    }
    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable("id") int id) {
        Student student= service.findById(id);
        StudentDTO dto = mapper.map(student,StudentDTO.class);
        return dto;
    }
    @DeleteMapping
    public void deleteAllById(@RequestBody List<Integer> ids) {
        service.deleteAllById(ids);
    }
    @PostMapping
    public void create(@RequestBody StudentCreateForm form) {
        service.create(form);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody StudentUpdateForm form) {
        form.setId(id);
        service.update(form);
    }
}
