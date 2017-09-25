//Arrays
class TestArray {
	
	public static void main(String args[]){
	
		int[] myList = {1,2,3,4,5,6,7,8};
		for (int i=0;i<myList.length;i++){
			System.out.println(myList[i]);
		}
		
		int sum = 0;
		for (int i=0;i<myList.length;i++){
			sum = sum + i;
		}
		System.out.println(sum);
	}
}