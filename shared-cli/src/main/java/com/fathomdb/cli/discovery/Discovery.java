package com.fathomdb.cli.discovery;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;

import com.google.common.collect.Lists;

public class Discovery {
    final ClassLoader classLoader;

    public Discovery(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Discovery() {
        this(Discovery.class.getClassLoader());
    }

    public List<Class<?>> findClasses(Package inPackage) {
        List<Class<?>> classes = Lists.newArrayList();

        List<URL> urls = Lists.newArrayList();

        if (classLoader instanceof URLClassLoader) {
            URLClassLoader urlClassLoader = (URLClassLoader) classLoader;

            String path = inPackage.getName().replace('.', '/');
            Enumeration<URL> resource;
            try {
                resource = urlClassLoader.findResources(path);
            } catch (IOException e) {
                throw new IllegalStateException("Error doing class discovery", e);
            }
            while (resource.hasMoreElements()) {
                urls.add(resource.nextElement());
            }
        } else {
            throw new UnsupportedOperationException();
        }

        for (URL url : urls) {
            // TODO: Check type of URL??
            String filePath = url.getFile();
            if (filePath != null) {
                File dir = new File(filePath);
                for (File classFile : dir.listFiles()) {
                    if (!classFile.isFile())
                        continue;
                    String name = classFile.getName();
                    if (!name.endsWith(".class"))
                        continue;
                    String rawName = name.replace(".class", "");
                    String qualifiedName = inPackage.getName() + "." + rawName;
                    try {
                        Class<?> clazz = Class.forName(qualifiedName);
                        classes.add(clazz);
                    } catch (Exception e) {
                        throw new IllegalStateException("Error loading class: " + qualifiedName, e);
                        // log.warn("Error loading class: " + qualifiedName, e);
                    }
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return classes;
    }

    public <T> List<T> buildInstances(Class<T> baseClass, List<Class<?>> classes) {
        List<T> instances = Lists.newArrayList();

        for (Class<?> clazz : classes) {
            int modifiers = clazz.getModifiers();
            if ((modifiers & Modifier.ABSTRACT) != 0) {
                continue;
            }
            if (!baseClass.isAssignableFrom(clazz)) {
                continue;
            }
            T instance;
            try {
                instance = (T) clazz.newInstance();
            } catch (InstantiationException e) {
                throw new IllegalStateException("Error instantiating class: " + clazz, e);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Error instantiating class: " + clazz, e);
            }
            instances.add(instance);
        }
        return instances;
    }

}
