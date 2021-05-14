import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class StringCalculator {
	
	public int add(String numbers) {
		int sum=0;
		//If String is empty
		if(numbers.isEmpty()) {
			return 0;
		}

		String [] num=numbers.split(",");
		//Output for one number only
		if(num.length==1) {
			return Integer.parseInt(num[0]);
		}
	
		//Output for unknown amount of numbers
		for(int i=0;i<num.length;i++) {
			sum=sum+Integer.parseInt(num[i]);
		}
		
		return sum;
	}
	
public static void main(String args[]) throws IOException {
	
      BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
      String numbers = bufferReader.readLine();
      
	  StringCalculator sc=new StringCalculator();
	  
	  System.out.println(sc.add(numbers));
	  
}
}
 