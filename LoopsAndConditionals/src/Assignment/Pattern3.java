package Assignment;

public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=15;
		//Pattern I
		for(int i=0;i<n;i++) {
			for(int j=0; j<n; j++) {
				if(i==0 
						|| i+j<=(n-1)/2 
						|| j-i>=(n-1)/2 
						|| i==n-1 || j==0 || j==n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		}
	}

}
