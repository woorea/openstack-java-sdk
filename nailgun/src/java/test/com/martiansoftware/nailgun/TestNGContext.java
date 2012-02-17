/*   

  Copyright 2004, Martian Software, Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

*/

package com.martiansoftware.nailgun;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Properties;

import junit.framework.TestCase;

/**
 * 
 * @author <a href="http://www.martiansoftware.com/contact.html">Marty Lamb</a>
 */
public class TestNGContext extends TestCase {
	
	public void testNGContextSettersAndGetters() {
		NGContext context = new NGContext();
		
		String[] args = { "a", "b", "c" };
		context.setArgs(args);
		context.setCommand("testCommand");
		Properties remoteEnv = new Properties();
		remoteEnv.setProperty("one", "1");
		remoteEnv.setProperty("two", "2");
		context.setEnv(remoteEnv);
		context.setPort(123);
		context.setWorkingDirectory("/test");
		
		assertEquals("b", context.getArgs()[1]);
		assertEquals("testCommand", context.getCommand());
		assertEquals("2", context.getEnv().getProperty("two"));
		assertEquals(123, context.getPort());
		assertEquals("/test", context.getWorkingDirectory());
		
		NGServer server = new NGServer();
		context.setNGServer(server);
		assertEquals(server, context.getNGServer());
	}

	public void testNGContextExit() {
		NGContext context = new NGContext();
		ByteArrayOutputStream exitStream = new ByteArrayOutputStream();
		context.setExitStream(new PrintStream(exitStream));

		context.exit(1);
		assertEquals('1', exitStream.toByteArray()[0]);
	}

	public void testNGContextLoopbackAssertion() throws Exception {
		NGContext context = new NGContext();
		context.setInetAddress(InetAddress.getLocalHost());
		assertEquals(InetAddress.getLocalHost(), context.getInetAddress());
		context.assertLocalClient();
		context.assertLoopbackClient();
	}

	public void testNGContextExternalInetAddress() throws Exception {

		NGContext context = new NGContext();
		InetAddress obviousExternal = InetAddress.getByName("www.google.com");
		context.setInetAddress(obviousExternal);
		assertEquals(obviousExternal, context.getInetAddress());
		try {
			context.assertLocalClient();
			fail(obviousExternal + " passed as local client.");
		} catch (Throwable t) {}
		try {
			context.assertLoopbackClient();
			fail(obviousExternal + " passed as local client.");
		} catch (Throwable t) {}
	}
	
	public void testNGContextNonLoopbackAssertions() throws Exception {
		NGContext context = new NGContext();
		int nonLoopbackAddressCount = 0;
		for (Enumeration e = NetworkInterface.getNetworkInterfaces(); e.hasMoreElements();) {
			NetworkInterface iface = (NetworkInterface) e.nextElement();
			
			for (Enumeration a = iface.getInetAddresses(); a.hasMoreElements();) {
				InetAddress addr = (InetAddress) a.nextElement();
				
				if (!addr.equals(InetAddress.getLocalHost())) {
					++nonLoopbackAddressCount;
					
					context.setInetAddress(addr);
					context.assertLocalClient();
					try {
						context.assertLoopbackClient();
						fail(addr + " passed as loopback client.");
					} catch (Throwable t) {}
				}
			}
		}
		if (nonLoopbackAddressCount == 0) {
			fail("No non-loopback addresses tested.  Sorry, but this test requires the test machine to have an IP address.");
		}
	}

}
