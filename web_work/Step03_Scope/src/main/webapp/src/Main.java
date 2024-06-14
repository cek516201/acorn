import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static Deque<Integer> intDeque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		intDeque = new ArrayDeque<Integer>(M);
		for (int i = 1; i <= N; i++) {
			intDeque.addLast(i);
		}

		int count = 0;
		for (int i = 1; i <= M; i++) {
			int num = Integer.parseInt(st.nextToken());
		}
		System.out.println(count);

		for (var elem : intDeque) {
			System.out.print(elem + " ");
		}
	}

	public static void moveLeft() {

	}

	public static void moveRight() {

	}
}