
public class TypeCastingSnippets1 {
	public static void main(String args[]) {
		byte num1=2;
		byte num2=5;
		// Any operation will be by default on int type even when the 
		//result is in range of the mentioned type
		/*
		byte res=num1*num2;
		System.out.println(res);
		*/
		
		//Type casting will not produce error
		byte pdt= (byte) (num1*num2);
		System.out.println(pdt);
		
		//Also result will be printed correctly for int data-type
		int product = num1*num2;
		System.out.println(product);
	}
}
