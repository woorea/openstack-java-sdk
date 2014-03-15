package com.woorea.openstack.examples.objectstore;

import java.util.LinkedHashMap;
import java.util.Map;

import com.woorea.openstack.swift.model.Objects;

public class PseudoFileSystem {

	private Map<String, PseudoFileSystem> directories = new LinkedHashMap<String, PseudoFileSystem>();
	private Map<String, com.woorea.openstack.swift.model.Object> files = new LinkedHashMap<String, com.woorea.openstack.swift.model.Object>();
	private com.woorea.openstack.swift.model.Object metaData;
	private PseudoFileSystem parent;

	public PseudoFileSystem(PseudoFileSystem parent, String childPath) {
		this.parent = parent;
		com.woorea.openstack.swift.model.Object object = new com.woorea.openstack.swift.model.Object();
		object.setName(childPath);
		this.setMetaData(object);
	}

	public Map<String, PseudoFileSystem> getDirectories() {
		return directories;
	}

	public Map<String, com.woorea.openstack.swift.model.Object> getFiles() {
		return files;
	}

	public static PseudoFileSystem readFromObjects(Objects objects) {
		PseudoFileSystem fs = new PseudoFileSystem(null, "");
		for (com.woorea.openstack.swift.model.Object object : objects) {
			String name = object.getName();
			if (!name.contains("/")) {
				fs.getFiles().put(name, object);
			} else {
				if (name.endsWith("/")) {
					PseudoFileSystem targetDirectory = findOrCreateChild(fs,
							name);
					targetDirectory.setMetaData(object);
				} else {
					String[] path = name.split("/");
					String directory = "";
					for (int i = 0; i < path.length - 1; i++) {
						directory += path[i] + "/";
					}
					PseudoFileSystem targetDirectory = findChild(fs, directory);
					targetDirectory.files.put(path[path.length - 1], object);
				}
			}
		}
		return fs;
	}

	public static PseudoFileSystem findOrCreateChild(PseudoFileSystem root,
			String childPath) {
		PseudoFileSystem currentLevel = root;
		String[] path = childPath.split("/");
		for (int i = 0; i < path.length; i++) {
			if (!currentLevel.directories.containsKey(path[i])) {
				currentLevel.directories.put(path[i], new PseudoFileSystem(
						currentLevel, childPath));
			}
			currentLevel = currentLevel.directories.get(path[i]);
		}
		return currentLevel;
	}

	public static PseudoFileSystem findChild(PseudoFileSystem root,
			String childPath) {
		PseudoFileSystem currentLevel = root;
		String[] path = childPath.split("/");
		for (int i = 0; i < path.length; i++) {
			if (!currentLevel.directories.containsKey(path[i])) {
				return null;
			}
			currentLevel = currentLevel.directories.get(path[i]);
		}
		return currentLevel;
	}

	public com.woorea.openstack.swift.model.Object getMetaData() {
		return metaData;
	}

	public void setMetaData(com.woorea.openstack.swift.model.Object metaData) {
		this.metaData = metaData;
	}

	public String toString() {
		return toString("  ");
	}

	public String toString(String ident) {
		StringBuilder builder = new StringBuilder();
		builder.append(getMetaData()).append("\n");
		for (Map.Entry<String, com.woorea.openstack.swift.model.Object> entry : getFiles()
				.entrySet()) {
			builder.append(ident).append("file ").append(entry.getValue())
					.append("\n");
		}
		for (Map.Entry<String, PseudoFileSystem> children : getDirectories()
				.entrySet()) {
			builder.append(ident).append("dir ")
					.append(children.getValue().toString(ident + "   "));
		}
		return builder.toString();
	}

	public PseudoFileSystem getParent() {
		return parent;
	}

	public PseudoFileSystem getRoot() {
		PseudoFileSystem p = this;
		while (p.getParent() != null) {
			p = p.getParent();
		}
		return p;
	}
}