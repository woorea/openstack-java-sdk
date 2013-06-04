package com.woorea.openstack.console;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.woorea.openstack.console.keystone.KeystoneEnvironment;
import com.woorea.openstack.console.nova.NovaEnvironment;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Environment environment = new Environment();
		environment.register(KeystoneEnvironment.KEYSTONE);
		environment.register(NovaEnvironment.NOVA);
		
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/console.properties"));
		
		Console console = new Console(environment, properties);
		console.start();
	}

}
