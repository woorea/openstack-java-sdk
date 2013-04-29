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

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Extensions;

/**
 *
 * @author Mr.Nam
 */
public class ExtensionCore {

  public static class ListExtensions implements OpenStackCommand<Extensions> {

    boolean detail;

    public ListExtensions(boolean detail) {
      this.detail = detail;
    }

    public ListExtensions() {
      this(false);
    }

    @Override
    public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
      request.path(detail ? "extensions/detail" : "extensions");
      request.header("Accept", "application/json");
      request.returnType(Extensions.class);
		return request;
    }
  }

  public static ListExtensions listExtensions(boolean detail) {
    return new ListExtensions(detail);
  }

  public static ListExtensions listExtensions() {
    return listExtensions(false);
  }
}
