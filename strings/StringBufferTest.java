//StringBuffer
class StringBufferTest {
	
	public static void main(String args[]){
		
		StringBuffer strb1 = new StringBuffer("Hello");
		int a = strb1.length();
		int b = strb1.capacity();
		char c = strb1.charAt(2);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(strb1.reverse());
	}
	
}