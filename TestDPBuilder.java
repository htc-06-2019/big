package fr.htc.spark.core;

public class TestDPBuilder {
	
	private String origin;
	private String dest;
	private String type;
	private int timeout;
	
	
	public static TestDPBuilder builder() {
		
		return new TestDPBuilder();
	}
	
	public TestDPBuilder origin(String ori) {
		
		this.origin = ori;
		return this;
	}
	public TestDPBuilder makeDest(String dest) {
		
		this.dest = dest;
		return this;
	}
	public TestDPBuilder type(String type) {
		
		this.type = type;
		return this;
	}
	public TestDPBuilder getOrCreate() {
		
		this.timeout = 1000;
		return this;
	}

	
	

}
