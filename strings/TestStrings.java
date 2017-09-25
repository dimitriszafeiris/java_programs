//Check start and end of a string
class TestStrings {
	
	public static void main(String args[]){
		
		String str1="You are ";
		String str2="welcome";
		String str3=str1.concat(str2);
		System.out.println(str3);
		
		str3.startsWith("You");
		str3.endsWith("welcome");
		
		
	}
	
}