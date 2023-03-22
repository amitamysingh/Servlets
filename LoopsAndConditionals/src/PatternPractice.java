
public class PatternPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=31;
		//Pattern Head
		for(int i=0;i<(n-1)/4;i++) {
			for(int j=0; j<n-1; j++) {
				if( i+j>=(n-1)/4
					 && j-i<=3*(n-1)/4 && i<=(n-1)/4 
					) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}System.out.println();
	}
		//Pattern Eyes
				for(int i=(n-1)/4;i<(n-1)/2;i++) {
					for(int j=0; j<n-1; j++) {
						if( (j>=(n-1)/8 && j<3*(n-1)/8) && (i==(n-1)/4 && j>(n-1)/8)
								
							) {
							System.out.print(" ");
						}else {
							System.out.print("*");
						}
					}System.out.println();
			}
		
	}
}
