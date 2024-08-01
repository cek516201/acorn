package com.example.boot13.entity;

import java.text.SimpleDateFormat;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneDto {
	// entity to dto
	public static PhoneDto toDto(Phone phone) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd E a hh:mm:ss", Locale.KOREA);
											 // ex) 2014.08.01 목 오후 6:10:30
		String stringRegdate = sdf.format(phone.getRegdate());
		
		return PhoneDto.builder()
				.id(phone.getId())
				.company(phone.getCompany())
				.name(phone.getName())
				.price(phone.getPrice())
				.regdate(stringRegdate)
				.build();
	}
	
	private long id;
	private String company;
	private String name;
	private Integer price;
	private String regdate;
}
