package com.example.boot13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name="PHONE_INFO") // 테이블 명
public class Phone {
	@Id // @Id 붙이면 primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String company;
	private String name;
	private int price;
}