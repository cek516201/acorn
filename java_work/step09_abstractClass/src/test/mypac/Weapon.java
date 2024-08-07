package test.mypac;

// class 예약어 앞에 abstract를 명시해서 클래스를 정의한다
// 형태만 정의되고 실제 구현은 되지 않은 메소드가 존재할 수 있다
// 형태만 정의된 메소드를 만들 때는 abstract 예약어를 붙여서 메소드를 정의한다
// 생성자는 존재하지만 단독으로 객체 생성은 불가하다
// 추상클래스 타입의 참조값이 필요하다면 추상클래스를 상속받은 자식클래스를 정의해서 객체를 생성한다
// 추상클래스를 상속받은 자식클래스는 부모의 추상메소드를 모두 오버라이드 해야한다

// 추상클래스 인터페이스 차이
// 추상클래스 : 다중상속 불가능
// 인터페이스 : 다중상속 가능
// 추상클래스와 인터페이스는 존재 목적이 다릅니다.
// 추상 클래스는 그 추상 클래스를 상속받아서 기능을 이용하고 확장시키는 데 있습니다.
// 인터페이스는 함수의 껍데기만 있는데, 그 함수의 구현을 강제하기 위해서 입니다.
// 구현을 강제함으로써 구현 객체의 같은 동작을 보장할 수 있습니다.

// 미완성된 추상메소드를 멤버로 가지고 있는 클래스는 abstract 예약어를 붙여서 정의 해야한다
public abstract class Weapon {
	public void prepare() {
		System.out.println("prepare");
	}

	// 공격을 하는 메소드의 모양만 정의하고 실제 구현은 하지 않기
	// 미완성된 추상메소드를 만들 때는 abstract 예약어가 필요
	public abstract void attack();
}