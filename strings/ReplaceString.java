//Replace
class ReplaceString {
	
	public static void main(String args[]){
		
		String str1="You are ";
		String str2="welcome";
		String str3=str1.concat(str2);
		System.out.println(str3);
		
		String str4 = str3.replace('o','a');
		System.out.println(str4);
	}
	
}