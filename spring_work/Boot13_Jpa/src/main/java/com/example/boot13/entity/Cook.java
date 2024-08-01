package com.example.boot13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity(name = "COOK")
public class Cook {
	// dto to entity
	public static Cook toEntity(CookDto dto) {
		return Cook.builder()
				.num(dto.getNum())
				.name(dto.getName())
				.recipe(dto.getRecipe())
				.build();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	private String name;
	private String recipe;
}