package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		Map<String, Object> strObjMap1 = new HashMap<String, Object>();
		strObjMap1.put("num", 1);
		strObjMap1.put("name", "ㅁㅁㅁ");
		strObjMap1.put("isMan", true);

		Map<String, Object> strObjMap2 = new HashMap<String, Object>();
		strObjMap2.put("num", 2);
		strObjMap2.put("name", "ㄴㄴㄴ");
		strObjMap2.put("isMan", false);

		Map<String, Object> strObjMap3 = new HashMap<String, Object>();
		strObjMap3.put("num", 3);
		strObjMap3.put("name", "ㅇㅇㅇ");
		strObjMap3.put("isMan", null);

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		mapList.add(strObjMap1);
		mapList.add(strObjMap2);
		mapList.add(strObjMap3);

		for (var strObjMap : mapList) {
			System.out.println(String.format("번호:%d 이름:%s 남성:%s", strObjMap.get("num"), strObjMap.get("name"),
					strObjMap.get("isMan")));
		}
	}
}