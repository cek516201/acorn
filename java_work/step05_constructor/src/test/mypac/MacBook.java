package test.mypac;

public class MacBook {
	public MacBook(Cpu cpu, Memory memory, HardDisk hardDisk) {
		this.cpu = cpu;
		this.memory = memory;
		this.hardDisk = hardDisk;
	}

	private Cpu cpu;
	private Memory memory;
	private HardDisk hardDisk;
}