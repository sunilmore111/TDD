import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.Line;
public class StringCalculator {
	
	public int add(String numbers) {
		int sum=0;
		//If String is empty
		if(numbers.isEmpty()) {
			return 0;
		}

		//Handle new lines \n and , in input
		String [] num=numbers.split("\\\\n|,");

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
 