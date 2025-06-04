package testRunner;

import java.util.stream.Stream;
import io.cucumber.core.cli.Main;

public class CommandLineRunner {

	private static String[] defaultOptions = { 
			"--glue", "stepDefinitions", 
			"--plugin", "pretty", "-m",
			"classpath:/features/"};

	public static void main(String[] args) {
		Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
		Main.main(cucumberOptions.toArray(String[]::new));
	}

}
