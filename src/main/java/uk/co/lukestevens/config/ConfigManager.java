package uk.co.lukestevens.config;

public interface ConfigManager {
	
	public Config getBaseConfig();
	
	public Config getSiteConfig(String site);

}
