import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	public int add(String numbers) throws IOException {
		int sum = 0;
		// If String is empty
		if (numbers.isEmpty()) {
			return 0;
		}

		// Regex to replace all characters except positive and negative numbers in a string
		String nums = numbers.replaceAll("[^-?0-9]+", " ");
		List<String> num = Arrays.asList(nums.trim().split(" "));
		ArrayList<Integer> negative = new ArrayList<>();
		try {
			
			for (int i = 0; i < num.size(); i++) {

				// Storing all negative numbers to pass in Exception
				if(Integer.parseInt(num.get(i)) < 0) {
					negative.add(Integer.parseInt(num.get(i)));
				}
			}	
			
			// Handling multiple negative numbers
			for (int i = 0; i < num.size(); i++) {
				
				if(negative.size() > 0) {
					throw new Exception("negatives not allowed " + " Negative number passed: "+Arrays.asList(negative));
				} else {
					sum = sum + Integer.parseInt(num.get(i));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return sum;
	}

	public static void main(String args[]) throws IOException {

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String numbers = bufferReader.readLine();

		StringCalculator sc = new StringCalculator();

		System.out.println(sc.add(numbers));

	}
}
