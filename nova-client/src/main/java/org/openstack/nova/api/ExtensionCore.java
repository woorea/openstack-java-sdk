/*
 * Copyright 2012 Mr.Nam.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openstack.nova.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Extensions;
import org.openstack.nova.model.Images;

/**
 *
 * @author Mr.Nam
 */
public class ExtensionCore {

  public static class ListExtensions implements NovaCommand<Extensions> {

    boolean detail;

    public ListExtensions(boolean detail) {
      this.detail = detail;
    }

    public ListExtensions() {
      this(false);
    }

    @Override
    public Extensions execute(WebTarget target) {
      String path = detail ? "extensions/detail" : "extensions";
      return target.path(path).request(MediaType.APPLICATION_JSON).get(Extensions.class);
      //throw new UnsupportedOperationException("Not supported yet.");
    }
  }

  public static ListExtensions listExtensions(boolean detail) {
    return new ListExtensions(detail);
  }

  public static ListExtensions listExtensions() {
    return listExtensions(false);
  }
}
