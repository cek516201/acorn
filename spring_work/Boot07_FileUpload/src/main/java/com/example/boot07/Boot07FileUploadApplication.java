package com.example.boot07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.example.boot07.dto.FileDto;

@PropertySource(value="classpath:custom.properties")
@SpringBootApplication
public class Boot07FileUploadApplication {
	public static void main(String[] args) {
		SpringApplication.run(Boot07FileUploadApplication.class, args);
		
		// lombok
		FileDto dto = FileDto.builder().num(1).writer("ㅁㅁㅁ").title("ㅁㅁㅁ").build();
		FileDto dto2 = new FileDto();
		dto2.setNum(2);
	}
}