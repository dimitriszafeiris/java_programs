//Multi arrays
class MultiArray {
	
	public static void main(String args[]){
	
		int arr[][] = new int [2][3];
		arr[0][0] = 1; 
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		System.out.println(arr[0][2]);
		System.out.println(arr[1][0]);
		System.out.println(arr[1][1]);
		System.out.println(arr[1][2]);
	
	//or..
	System.out.println("Or...");
	for (int i =0;i<arr.length;i++){
		for (int j=0;j<arr[i].length;j++){
			System.out.println(arr[i][j]);
		}
	}
	
	}
}