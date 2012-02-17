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

import junit.framework.TestCase;

/**
 * 
 * @author <a href="http://www.martiansoftware.com/contact.html">Marty Lamb</a>
 */
public class TestNailStats extends TestCase {

	public void testNailStats() {
		NailStats ns = new NailStats(TestNailStats.class);

		assertEquals(TestNailStats.class, ns.getNailClass());
		
		for (int i = 0; i < 1000; ++i) {
			ns.nailStarted();
			assertEquals(i + 1, ns.getRunCount());
			assertEquals(1, ns.getRefCount());
			ns.nailFinished();
		}
		assertEquals(1000, ns.getRunCount());
		assertEquals(0, ns.getRefCount());

		NailStats ns2 = (NailStats) ns.clone();
		assertEquals(ns, ns2);
		assertEquals(ns.hashCode(), ns2.hashCode());
		
		assertEquals("com.martiansoftware.nailgun.TestNailStats: 1000/0", ns.toString());
	}
}
