import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		try {
			for (int i = 0; i < num.size(); i++) {

				// Throw Exception if negative number found and return sum 0
				if(Integer.parseInt(num.get(i)) < 0) {
					throw new Exception("negatives not allowed " + " Negative number passed: "+Integer.parseInt(num.get(i)));
				}else {
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
