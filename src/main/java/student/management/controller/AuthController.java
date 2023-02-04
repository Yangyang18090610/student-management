package student.management.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.management.dto.ProfileDTO;
import student.management.entity.Student;
import student.management.form.AuthUpdateForm;
import student.management.form.StudentCreateForm;
import student.management.service.IStudentService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private ModelMapper mapper;

    @Autowired
    private IStudentService service;

    @PostMapping("register")
    public void register(@RequestBody StudentCreateForm form){
        service.create(form);
    }
    @GetMapping("/login")
//    Principal chứa username đăng nhập thành công trước đó
    public ProfileDTO login(Principal principal){
        String username = principal.getName();
        Student student = service.findByUserName(username);
        ProfileDTO pdto = mapper.map(student, ProfileDTO.class);
        return pdto;
    }
    @PostMapping("/change")
    public void update (@RequestBody AuthUpdateForm form){
        service.updateAuth(form);
    }
}
