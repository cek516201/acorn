package test.main;

import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println();
//		 public static class System {
//		    public static PrintStream out;
//		 }
		PrintStream aaa = System.out;
		aaa.println();
	}
}