import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] a) throws IOException {
		solve();
	}

	/**
	 * 문제 해결 로직
	 */
	static void solve() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();

		int placeCount = Integer.parseInt(br.readLine());

		int[] useSource = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] places = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


		Arrays
	}
}

