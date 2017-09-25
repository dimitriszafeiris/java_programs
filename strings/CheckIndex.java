//Check index of string
class CheckIndex {
	
	public static void main(String args[]){
		
		String str1="You are ";
		String str2="welcome";
		String str3=str1.concat(str2);
		System.out.println(str3);
		
		int a=str3.indexOf('o');
		System.out.println(a);
	}
	
}