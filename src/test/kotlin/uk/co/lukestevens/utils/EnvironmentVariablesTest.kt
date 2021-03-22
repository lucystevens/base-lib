package uk.co.lukestevens.utils;

import org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import uk.co.lukestevens.testing.mocks.EnvironmentVariableMocker;

class EnvironmentVariablesTest {

	
	@Test
	fun testGetVariables_system() {
		assertEquals(System.getenv(), EnvironmentVariables.get());
	}
	
	@Test
	fun testGetVariables_mocked() {
		val variables = mutableMapOf<String, String>();
		variables.put("key", "value");
		variables.put("JAVA_HOME", "mocked");
		
		EnvironmentVariableMocker.build(variables).mock();	
		assertEquals(variables, EnvironmentVariables.get());
		
		EnvironmentVariableMocker.clear();
		assertEquals(System.getenv(), EnvironmentVariables.get());
	}
	
	
	@Test
	fun testGetVariable() {
		assertEquals(System.getenv("JAVA_HOME"), EnvironmentVariables.get("JAVA_HOME"));
	}
	
	@Test
	fun testGetVariable_mocked() {
		val variables = mutableMapOf<String, String>();
		variables.put("key", "value");
		
		val props = Properties();
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
