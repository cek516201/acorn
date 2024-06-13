package test.main;

import test.mypac.Cpu;
import test.mypac.HardDisk;
import test.mypac.MacBook;
import test.mypac.Memory;

public class MainClass03 {
	public static void main(String[] args) {
		MacBook mac1 = new MacBook(new Cpu(), new Memory(), new HardDisk());

		Cpu c1 = new Cpu();
		Memory m1 = new Memory();
		HardDisk hd1 = new HardDisk();
		MacBook mac2 = new MacBook(c1, m1, hd1);
	}
}