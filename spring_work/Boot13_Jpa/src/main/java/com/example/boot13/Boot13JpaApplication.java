package com.example.boot13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.boot13.entity.Phone;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class Boot13JpaApplication {
	@PostConstruct
	public void init() {
		// 이 객체를 영속화(영구 저장)하고싶다
		Phone p1 = Phone.builder().name("아이폰15").company("apple").price(150).build();
		Phone p2 = Phone.builder().name("갤럭시S15").company("samsung").price(130).build();
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// EntityManager 객체의 메소드를 이용해서 저장한다
			em.persist(p1);
			em.persist(p2);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

	}
	
	public static void main(String[] args) {
		SpringApplication.run(Boot13JpaApplication.class, args);
	}
	
	@Autowired
	EntityManagerFactory emf;
}