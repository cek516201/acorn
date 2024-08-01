package com.example.boot13.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CookDto {
	// entity to dto
	public static CookDto toDto(Cook entity) {
		return CookDto.builder()
				.num(entity.getNum())
				.name(entity.getName())
				.recipe(entity.getRecipe())
				.build();
	}
	
	private long num;
	private String name;
	private String recipe;
}