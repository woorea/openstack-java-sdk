package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.compute.AddressList;
import org.openstack.model.compute.nova.NovaAddressList;
import org.openstack.model.compute.nova.NovaAddressList.Network.Ip;

import com.google.common.collect.Maps;

public class AddressesFormatter extends SimpleFormatter<AddressList> {

    public AddressesFormatter() {
        super(NovaAddressList.class);
    }

    @Override
    public void visit(AddressList o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        StringBuilder sb = new StringBuilder();
        formatNetworks(sb, o.getNetworks());

        values.put("networks", sb.toString());

        sink.outputRow(values);
    }

    public static String formatAddresses(AddressList addresses) {
        if (addresses == null)
            return null;

        StringBuilder sb = new StringBuilder();
        formatNetworks(sb, addresses.getNetworks());
        return sb.toString();
    }

    public static void formatNetworks(StringBuilder sb, List<NovaAddressList.Network> networks) {
        if (networks != null) {
            for (int i = 0; i < networks.size(); i++) {
                if (i != 0)
                    sb.append(",");
                formatNetwork(sb, networks.get(i));
            }
        }
    }

    public static void formatNetwork(StringBuilder sb, NovaAddressList.Network network) {
        sb.append(network.getId() + "=");
        List<Ip> ips = network.getIps();
        formatIps(sb, ips);
    }

    public static void formatIps(StringBuilder sb, List<Ip> ips) {
        if (ips != null) {
            for (int i = 0; i < ips.size(); i++) {
                if (i != 0)
                    sb.append(",");
                sb.append(ips.get(i).getAddr());
            }
        }
    }
}
