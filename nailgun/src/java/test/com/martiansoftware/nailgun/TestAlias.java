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
 * @author Owner
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestAlias extends TestCase {

	public void testAlias() {
		Alias alias = new Alias("testAlias", "tests the alias class", TestAlias.class);
		assertEquals("testAlias", alias.getName());
		assertEquals("tests the alias class", alias.getDescription());
		assertEquals(TestAlias.class, alias.getAliasedClass());
		Alias alias2 = new Alias("testAlias", "tests the alias class", TestAlias.class);
		assertEquals(alias, alias2);
		assertEquals(0, alias.compareTo(alias2));
	}
}
