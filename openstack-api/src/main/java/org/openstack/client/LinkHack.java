package org.openstack.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.openstack.model.atom.Link;

public class LinkHack {

	public static void fixLinkHref(Link link) {
		/*
		// dirty hack since urls are not correct in the XML
		// may this is fixed in the current revision
		// so simply comment this

		// This may actually be because the link shouldn't embed the client version?
		// If this isn't just a hack, we should probably avoid changing the Link URI!

		try {
			URI uri = URI.create(link.getHref());
			String path = uri.getPath();

			URI rootUri = URI.create(session.getComputeClient().getRootUrl());

			String version = "/v1.1";
			if (rootUri.getPath().startsWith("/v2/")) {
				version = "/v2";
			}

			if (!path.startsWith(version + "/")) {
				path = version + path;
				uri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), path, uri.getQuery(), uri.getFragment());
				link.setHref(uri.toString());
			}
		} catch (URISyntaxException e) {
			throw new IllegalStateException("Error parsing link href", e);
		}
		*/
	}
	
	public static void main(String[] args) {
		URI uri = URI.create("http://192.168.1.52:8774/7e8b7cd65def4a29957b279f965ec5c5/images/16c626ff-7ed1-4731-a617-9bb520edc376");
		System.out.println(uri.getPath());
	}
	
}
