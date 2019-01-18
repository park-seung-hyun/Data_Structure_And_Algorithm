// GenericClassTester
// pg130 
// 제너릭 (Generic)
// 자료형에 의존하지 않는 범용적인 클래스 

public class GenericClassTester {
	// 제너릭은 처리해야할 대상의 자료형에 의존하지 않는 클래스(인터페이스) 구현 방식 
	// 자료형에 의존하지 않으므로 범용으로 사용 가능 
	static class GenericClass<T>{ // 제너릭 클래스 선언 
		// T라는 자료형을 전달 받음. 
		// ex) String, Integer 
		private T xyz; 
		GenericClass(T t){
			this.xyz = t;
		}
		T getXyz() {
			return xyz;
		}
	}
	
	public static void main (String[] args) {
		GenericClass<String> s = new GenericClass<String>("abc"); // 자료형 String을 전달받음. 
		GenericClass<Integer> i = new GenericClass<Integer>(1); // 자료형 Integer를 전달받음.
		System.out.println(s.getXyz());
		System.out.println(i.getXyz());
	}
}
