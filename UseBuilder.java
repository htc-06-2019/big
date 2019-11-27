package fr.htc.spark.core;

public class UseBuilder {

	public static void main(String[] args) {
		TestDPBuilder testDPBuilder = TestDPBuilder
				.builder()
				.origin("oraclejshkjqh")
				.type("ETL")
				.makeDest("WS")
				.getOrCreate();

		System.out.println(testDPBuilder);

	}

}
