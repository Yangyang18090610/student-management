package student.management.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;
import student.management.dto.SchoolDTO;
import student.management.entity.School;
import student.management.form.SchoolCreateForm;
import student.management.form.SchoolFilterForm;
import student.management.form.SchoolUpdateForm;
import student.management.service.ISchoolService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ISchoolService service;

    @GetMapping
    public Page<SchoolDTO> findAll(@SortDefault(value = "totalMembers", direction = Sort.Direction.DESC) Pageable pageable, SchoolFilterForm form) {
        Page<School> page = service.findAll(pageable, form);
        List<School> schoool = page.getContent();
        List<SchoolDTO> dtos = mapper.map(
                schoool,
                new TypeToken<List<SchoolDTO>>(){}.getType());
        return new PageImpl<>(dtos,pageable, page.getTotalElements());
    }
    @GetMapping("/{id}")
    public SchoolDTO findById(@PathVariable("id") int id){
        School school = service.findById(id);
        SchoolDTO dto = mapper.map(school, SchoolDTO.class);
        return dto;
    }

    @PostMapping
    public void create (@RequestBody SchoolCreateForm form){
        System.out.println(form);
        service.create(form);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id")int id,@RequestBody SchoolUpdateForm form){
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")int id){
        service.deleteById(id);
    }
}
