package org.openstack.console.common;

public abstract class StringWrapper {
    final String key;

    public String getKey() {
        return key;
    }

    protected StringWrapper(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return getClass().getName() + " [" + key + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringWrapper other = (StringWrapper) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }

}