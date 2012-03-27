package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.nova.keypair.NovaKeyPair;

import com.google.common.collect.Maps;

public class KeypairFormatter extends SimpleFormatter<KeyPair> {

    public KeypairFormatter() {
        super(NovaKeyPair.class);
    }

    @Override
    public void visit(KeyPair o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("name", o.getName());
        values.put("fingerprint", o.getFingerprint());
        values.put("public_key", o.getPublicKey());

        sink.outputRow(values);
    }
}
