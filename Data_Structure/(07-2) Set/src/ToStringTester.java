// ToStringTester
// pg285
// toString 오버라이딩 

class A{
	
}
class B{
	int x;
	B(int x){
		this.x = x;
	}
	public String toString() { // Object 클래스의 toString()을 오버라이드 
		return "B["+x+"]";
	}
}
public class ToStringTester {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		B b1 = new B(18);
		B b2 = new B(55);
		System.out.println(a1.toString());
		System.out.println(a2);
		System.out.println(b1.toString());
		System.out.println(b2);
	}
}
