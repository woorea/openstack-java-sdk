package org.openstack.ceilometer.libvirt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.libvirt.Domain;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class LibvirtUtils {

	private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();

	private static final XPath XPATH = XPathFactory.newInstance().newXPath();

	public static Set<String> getDisks(Domain domain) {
		Set<String> devices = new HashSet<String>();
		try {
			NodeList nl = (NodeList) eval(domain,"/domain/devices/disk/target", XPathConstants.NODESET);
			for (int i = 0; i < nl.getLength(); i++) {
				devices.add(nl.item(i).getAttributes().getNamedItem("dev").getNodeValue());
			}
			return devices;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static Set<String> getInterfaces(Domain domain) {
		Set<String> ifaces = new HashSet<String>();
		try {
			NodeList nl = (NodeList) eval(domain,"/domain/devices/interface/target", XPathConstants.NODESET);
			for (int i = 0; i < nl.getLength(); i++) {
				ifaces.add(nl.item(i).getAttributes().getNamedItem("dev").getNodeValue());
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return ifaces;

	}
	
	private static Object eval(Domain domain, final String xpath, final QName qname) {
		try {
			InputStream is = new ByteArrayInputStream(domain.getXMLDesc(0).getBytes("UTF-8"));
			Document doc = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder().parse(is);
			return XPATH.compile(xpath).evaluate(doc, qname);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}

