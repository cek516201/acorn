package test.mypac;

public class FruitBox<T> {
	public T unPack() {
		return item;
	}

	public void pack(T item) {
		this.item = item;
	}

	private T item;
}