// Id
// pg121 
// 클래스 메서드와 인스턴스 메서드 차이 

public class Id {
	private static int counter = 0; // 클래스 
	private int id;
	
	public Id() {
		id = ++counter;
	}
	public int getId() {
		return id;
	}
	public static int getCounter() { // 클래스
		return counter;
	}
	public static void main (String args[]) {
		Id a = new Id();
		Id b = new Id();
		
		System.out.println("a의 ID: " + a.getId()); // 인스턴스를 통해 호출함. 
		System.out.println("a의 ID: " + b.getId()); // 인스턴스를 통해 호출함. 
		System.out.println("부여된 ID 수: " + Id.getCounter()); // 클래스를 통해 호출함. 
	}
}
