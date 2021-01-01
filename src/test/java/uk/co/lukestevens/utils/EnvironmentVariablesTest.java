package uk.co.lukestevens.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import uk.co.lukestevens.testing.mocks.EnvironmentVariableMocker;

public class EnvironmentVariablesTest {

	
	@Test
	public void testGetVariables_system() {
		assertEquals(System.getenv(), EnvironmentVariables.get());
	}
	
	@Test
	public void testGetVariables_mocked() {
		Map<String, String> variables = new HashMap<>();
		variables.put("key", "value");
		variables.put("JAVA_HOME", "mocked");
		
		EnvironmentVariableMocker.build(variables).mock();	
		assertEquals(variables, EnvironmentVariables.get());
		
		EnvironmentVariableMocker.clear();
		assertEquals(System.getenv(), EnvironmentVariables.get());
	}
	
	
	@Test
	public void testGetVariable() {
		assertEquals(System.getenv("JAVA_HOME"), EnvironmentVariables.get("JAVA_HOME"));
	}
	
	@Test
	public void testGetVariable_mocked() {
		Map<String, String> variables = new HashMap<>();
		variables.put("key", "value");
		
		Properties props = new Properties();
		props.put("property", "prop-value");
		
		EnvironmentVariableMocker.build(variables)
			.with(props)
			.with("JAVA_HOME", "mocked")
			.mock();
		
		assertEquals("value", EnvironmentVariables.get("key"));
		assertEquals("prop-value", EnvironmentVariables.get("property"));
		assertEquals("mocked", EnvironmentVariables.get("JAVA_HOME"));
		
		EnvironmentVariableMocker.clear();
		assertEquals(System.getenv("JAVA_HOME"), EnvironmentVariables.get("JAVA_HOME"));
	}
}
