// IntSet 
// pg278 
// 배열로 만드는 집합 

public class IntSet {
	private int max; // 집합의 최대 개수 
	private int num; // 집합의 요소 개수 
	private int[] set; // 집합 본체 
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; // 집합 배열 생성 
		}catch(OutOfMemoryError e) { // 배열 생성 실패 
			max = 0;
		}
	}
	// 집합의 최대 개수 
	public int capacity() {
		return max;
	}
	// 집합의 요소 개수 
	public int size() {
		return num;
	}
	// 집합에서 n을 검색 (해당 인덱스 반환)
	public int indexOf(int n) {
		for(int i=0;i<num;i++) {
			if(set[i] == n)
				return i;
		}
		return -1;
	}
	// 집합에 n이 있는지 없는지 확인 
	public boolean contains(int n) {
		return (indexOf(n)!=-1)?true:false;
	}
	// 집합에 n을 추가 
	public boolean add(int n) {
		if(num>=max||contains(n)==true) // 가득 찼거나, 이미 가지고 있을 경우 
			return false;
		else {
			set[num++] = n;
			return true;
		}
	}
	// 집합에서 n을 삭제 
	public boolean remove(int n) {
		int idx;
		if(num<=0||(idx = indexOf(n))== -1) // 비어있거나, 없을 경우 
			return false;
		else {
			set[idx] = set[--num]; // 마지막 요소를 삭제한 인덱스로 이동 
			return true;
		}
	}
	// 집합 s에 복사 
	public void copyTo(IntSet s) {
		int n = (s.max<num)?s.max:num; // 복사할 요소 개수 
		for(int i=0;i<n;i++) {
			s.set[i] = set[i];
		}
		s.num = n;
	}
	// 집합 s를 복사 
	public void copyFrom(IntSet s) {
		int n = (max<s.num)?max:s.num; // 복사할 요소 개수 
		for(int i=0;i<n;i++) {
			set[i] = s.set[i];
		}
		num = n;
	}
	// 집합 s와 같은지 확인 
	public boolean equalTo(IntSet s) {
		if(num!=s.num) // 요소 개수가 같지 않으면 두 집함은 다름.
			return false;
		for(int i=0;i<num;i++) {
			int j=0;
			for(;j<s.num;j++)
				if(set[i]==s.set[j])
					break;
			if(j==s.num) // set[i]는 s에 포함되지 않음. 
				return false;
		}
		return true;
	}
	// 집합 s1, s2의 합집합을 복사
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1); // 집합 s1을 복사 
		for(int i=0;i<s2.num;i++) { // 집합 s2의 요소를 추가 
			add(s2.set[i]);
		}
	}
	// 문자열 표현으로 변경 
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ") ;
		for(int i=0;i<num;i++)
			temp.append(set[i]+ " ");
		temp.append("}");
		return temp.toString();
	}
}

