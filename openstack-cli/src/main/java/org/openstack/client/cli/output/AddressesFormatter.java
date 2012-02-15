package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openstack.model.compute.Addresses;
import org.openstack.model.compute.Addresses.Network.Ip;
import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;

import com.google.common.collect.Maps;

public class AddressesFormatter extends SimpleFormatter<Addresses> {

    public AddressesFormatter() {
        super(Addresses.class);
    }

    @Override
    public void visit(Addresses o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        StringBuilder sb = new StringBuilder();
        formatNetworks(sb, o.networks);

        values.put("networks", sb.toString());

        sink.outputRow(values);
    }

    public static String formatAddresses(Addresses addresses) {
        if (addresses == null)
            return null;

        StringBuilder sb = new StringBuilder();
        formatNetworks(sb, addresses.networks);
        return sb.toString();
    }

    public static void formatNetworks(StringBuilder sb, List<Addresses.Network> networks) {
        if (networks != null) {
            for (int i = 0; i < networks.size(); i++) {
                if (i != 0)
                    sb.append(",");
                formatNetwork(sb, networks.get(i));
            }
        }
    }

    public static void formatNetwork(StringBuilder sb, Addresses.Network network) {
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
