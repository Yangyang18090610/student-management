package student.management;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import student.management.entity.Student;
import student.management.form.StudentCreateForm;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(StudentCreateForm.class, Student.class)
				.addMappings(mapper -> mapper.skip(Student::setId));
		return modelMapper;
	}
}
