package com.example.boot13.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
@Entity(name = "PHONE_INFO") // 테이블 명
public class Phone {
	@Id // @Id 붙이면 primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String company;
	private String name;
	// null값이 가능한 Entity 필드는 반드시 참조 data type이어야한다
	@Column(nullable = true)
	private Integer price;
	@Column(nullable = false)
	private Date regdate;

	// Entity를 영속화하기 직전에 뭔가 작업할게 있으면 @PrePersist 어노테이션을 활용하면 된다
	@PrePersist
	public void onPersist() {
		// 오라클에서 데이터를 넣을때 SYSDATE 함수를 이용해서 넣는 효과를 낸다
		regdate = new Date();
	}
}