import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	public int add(String numbers) {
		int sum=0;
		//If String is empty
		if(numbers.isEmpty()) {
			return 0;
		}

		//Regex to replace all character except numbers in a string
		String nums = numbers.replaceAll("[^0-9]+", " ");
		List<String> num = Arrays.asList(nums.trim().split(" "));
		for(int i=0;i<num.size();i++) {
			sum=sum+Integer.parseInt(num.get(i));
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
