package org.openstack.model.compute.nova.extendedstatus;

import javax.xml.bind.annotation.XmlAttribute;

public class ExtendedStatusAttributes {
    @XmlAttribute(name = "vm_state")
    public String vmState;

    @XmlAttribute(name = "task_state")
    public String taskState;

    @XmlAttribute(name = "power_state")
    public String powerState;

    @Override
    public String toString() {
        return "ExtendedStatusAttributes [vmState=" + vmState + ", taskState=" + taskState + ", powerState=" + powerState + "]";
    }

}
