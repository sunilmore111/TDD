import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator implements AddListener {

	static int count = 0, sum = 0;

	// Method to count how many times add () was called
	public int getCalledCount() {
		count++;
		return count;
	}

	public int add(String numbers) throws IOException {

		getCalledCount();

		// If String is empty
		if (numbers.isEmpty()) {
			return sum;
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
					
					// Ignore numbers greater than 1000
					if(Integer.parseInt(num.get(i)) <= 1000) {
						sum = sum + Integer.parseInt(num.get(i));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return sum;
	}

	// Method for add() trigger
	@Override
	public void addOccured(String numbers) {

		// Pattern modified for Delimiters of any length
		Pattern pattern = Pattern.compile("[//]*[-?0-9]*(\\\\n)?([,*;]*(\\\\n)?[-?0-9]+)+");

		try {

			if(pattern.matcher(numbers).matches()) {
				add(numbers);
				System.out.println("Add() Triggered");
			}
			else {
				System.out.println("Add() was not Triggered ");
			} 

		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws IOException {

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String numbers = bufferReader.readLine();

		StringCalculator sc = new StringCalculator();

		if(numbers.isEmpty()) { 
			sc.add(numbers);
		}else {
			sc.addOccured(numbers);
			while(!(numbers=bufferReader.readLine()).isEmpty()) {	
				sc.addOccured(numbers);
			}
		}

		System.out.println(sum);

		System.out.println("The Add() was called "+ count +" times");
	}
}
