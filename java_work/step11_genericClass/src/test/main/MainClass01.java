package test.main;

import test.mypac.FruitBox;
import test.mypac.Apple;
import test.mypac.Melon;
import test.mypac.Orange;

public class MainClass01 {
	public static void main(String[] args) {
		FruitBox<Apple> box1 = new FruitBox<Apple>();
		box1.pack(new Apple());
		Apple a1 = box1.unPack();

		FruitBox<Melon> box2 = new FruitBox<>(); // <> 내 생략 가능
		box2.pack(new Melon());
		Melon m1 = box2.unPack();

		FruitBox<Orange> box3 = new FruitBox<>(); // <> 내 생략 가능
		box3.pack(new Orange());
		Orange o1 = box3.unPack();
	}
}