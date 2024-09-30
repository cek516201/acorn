package com.example.boot14;

// static import를 하면 이 클래스에서 import 메소드를 호출할때 클래스명을 생략할수 있다
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.boot14.dto.MemberDto;
import com.example.boot14.repository.MemberDao;

@SpringBootTest
// 테스트 코드가 끝나면 자동으로 롤백되는 어노테이션
@Transactional
class Boot14ReactApiApplicationTests {
    @Autowired MemberDao dao;

    // @Test 어노테이션을 이용해서 테스트 case 메소드를 작성한다
    @Test
    void contextLoads() {
        // 어떤 메소드가 리턴해주는 값이라고 가정
        int sum = 1 + 2;
        // 그 값은 반드시 2여야 한다는 단언
        // 2이면 pass 아니면 fail
        assertEquals(sum, 2);
    }

    @Test
    void testIsNull() {
        String str = null;
        // null이면 pass 아니면 fail
        assertNull(str);
    }

    @Test
    void testNotNull() {
        String str = "aaa";
        // not null이면 pass 아니면 fail
        assertNotNull(str);
    }

    @Test
    void testIsTrue() {
        boolean isRun = false;
        // true이면 pass 아니면 fail
        assertTrue(isRun);
        assertTrue(isRun, "달릴지 여부는 true여야한다");
    }

    @Test
    void testMemberDaoNotNull() {
        assertNotNull(dao);
    }

    @Test
    void testMemberDaoInsert() {
        // 회원번호를 얻어낸다
        int num = dao.getSequence();
        // 저장할 회원 정보를 MemberDto에 담는다
        MemberDto dto = MemberDto.builder().num(num).name("test_name").addr("test_addr").build();
        // 회원정보를 저장한다
        dao.insert(dto);
        // 회원정보를 읽어와서 비교한다
        MemberDto savedDto = dao.getData(num);
        assertEquals(savedDto.getName(), "test_name");
        assertEquals(savedDto.getAddr(), "test_addr");
    }
}