//Max array
class MaxArray {
	
	public static void main(String args[]){
	
		int[] myList = {1,2,3,4,5,6,7,8};
		int max = myList[0];
		for (int i=0;i<myList.length;i++){
			if (myList[i]>max)
				max = myList[i];
		}
		System.out.println(max);
	}
}