package javax.xml.namespace;

import java.io.Serializable;

public class QName implements Serializable {

	private String namespaceURI;

	private String localPart;

	private String prefix;
	
	public QName() {
		this.namespaceURI = "";
		this.localPart = "";
		this.prefix = "";
	}

	public QName(final String namespaceURI, final String localPart) {
		this(namespaceURI, localPart, "");
	}

	public QName(String namespaceURI, String localPart, String prefix) {
		// map null Namespace URI to default
		// to preserve compatibility with QName 1.0
		if (namespaceURI == null) {
			this.namespaceURI = "";
		} else {
			this.namespaceURI = namespaceURI;
		}

		// local part is required.
		// "" is allowed to preserve compatibility with QName 1.0
		if (localPart == null) {
			throw new IllegalArgumentException(
					"local part cannot be \"null\" when creating a QName");
		}
		this.localPart = localPart;

		// prefix is required
		if (prefix == null) {
			throw new IllegalArgumentException(
					"prefix cannot be \"null\" when creating a QName");
		}
		this.prefix = prefix;
	}

	public QName(String localPart) {
		this("", localPart, "");
	}
	
	public String getNamespaceURI() {
		return this.namespaceURI;
	}
	
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	
	public String getLocalPart() {
		return this.localPart;
	}
	
	public void setLocalPart(String localPart) {
		this.localPart = localPart;
	}
	
	public String getPrefix() {
		return this.prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}