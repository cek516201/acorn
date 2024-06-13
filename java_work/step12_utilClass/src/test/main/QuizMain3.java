package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.PostDto;

public class QuizMain3 {
	public static void main(String[] args) {
		List<PostDto> postList = new ArrayList<PostDto>(3);
		postList.add(new PostDto(PostDto.getNextNum(), "qweqwe", "ㅁㅁㅁ"));
		postList.add(new PostDto(PostDto.getNextNum(), "asdasd", "ㄴㄴㄴ"));
		postList.add(new PostDto(PostDto.getNextNum(), "zxczxc", "ㅇㅇㅇ"));

		System.out.println("번호           제목          작성자");
		for (var elem : postList) {
			System.out.printf(" %d          %s        %s\n", elem.getNum(), elem.getTitle(), elem.getWriter());
		}
	}
}