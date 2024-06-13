package test.main;

import java.util.HashMap;
import java.util.Map;
import test.mypac.Car;

public class MainClass08 {
	public static void main(String[] args) {
		// HashMap 객체 생성해서 참조값을 map 인터페이스 type 지역변수에 담기
		Map<String, Object> strObjMap = new HashMap<String, Object>();
		strObjMap.put("num", 1);
		strObjMap.put("name", "ㅁㅁㅁ");
		strObjMap.put("isMan", true);
		strObjMap.put("car", new Car("소나타"));

		int num = (int) strObjMap.get("num");
		String name = (String) strObjMap.get("name");
		boolean isMan = (boolean) strObjMap.get("isMan");
		Car car = (Car) strObjMap.get("car");

		// 동일한 key값으로 다시 put하면 수정
		strObjMap.put("name", "aaa");

		System.out.println(strObjMap.remove("num"));
		strObjMap.clear();
	}
}