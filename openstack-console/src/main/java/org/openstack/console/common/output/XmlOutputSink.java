package org.openstack.console.common.output;
//package org.platformlayer.cli.output;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
//import javax.xml.bind.JAXBException;
//
//public class XmlOutputSink implements OutputSink {
//    final PrintWriter out;
//
//    public XmlOutputSink(PrintWriter out) {
//        super();
//        this.out = out;
//    }
//
//    @Override
//    public void visitObject(Object o) throws IOException {
//        try {
//            out.println(JaxbHelper.toXml(o, true));
//        } catch (JAXBException e) {
//            throw new IOException("Error serializing to XML", e);
//        }
//    }
//
//    @Override
//    public void outputRow(Map<String, Object> values) {
//        throw new IllegalStateException();
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public void finishOutput() {
//    }
//}
