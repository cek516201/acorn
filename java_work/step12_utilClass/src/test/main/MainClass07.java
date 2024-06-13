package test.main;

import java.util.HashMap;

public class MainClass07 {
	public static void main(String[] args) {
		// HashMap<key type, value type>

		// key type은 일반적으로 string type을 가장 많이 사용한다
		// value type은 담고 싶은 데이터의 type을 고려해서 지정하면 된다
		// value type을 object로 지정하면 어떤 type이던이 담을 수 있다
		// 순서가 없는 데이터를 다룰 때 사용하면 된다
		// dto클래스 대신에 사용하기도 한다
		HashMap<String, Object> strObjMap = new HashMap<>();
		System.out.println(strObjMap.put("num", 1));
		System.out.println(strObjMap.put("num", 2));
		System.out.println(strObjMap.put("name", "ㅁㅁㅁ"));
		System.out.println(strObjMap.put("name", "ㄴㄴㄴ"));
		System.out.println(strObjMap.put("isMan", true));
		System.out.println(strObjMap.put("isMan", false));

		int num = (int) strObjMap.get("num");
		String name =  (String) strObjMap.get("name");
		boolean isMan = (boolean) strObjMap.get("isMan");
		System.out.println(num + " " + name + " " + isMan);

		/*  위의 7 줄의 코드를 javascript 로 표현한다면 아래와 같다
		 *  
		 *  let map = {};
		 *  map.num = 1;
		 *  map.name = "김구라";
		 *  map.isMan = true;
		 *  
		 *  let num = map.num;
		 *  let name = map.name;
		 *  let isMan = map.isMan;
		 *  
		 *  아래의 코드도 가능하다
		 *  let map = {};
		 *  map["num"] = 1;
		 *  map["name"] = "김구라";
		 *  map["isMan"] = true; 
		 *  
		 *  let num = map["num"];
		 *  let name = map["name"];
		 *  let isMan = map["isMan"];
		 */
	}
}