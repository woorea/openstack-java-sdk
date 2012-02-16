//package org.openstack.model.image;
//
//import java.util.Iterator;
//import java.util.List;
//
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.google.common.collect.Lists;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement
//public class GlanceImageProperty {
//    public String key;
//    public String value;
//
//    public static List<GlanceImageProperty> deserializeProperties(JSONObject jsonObject) throws JSONException {
//        List<GlanceImageProperty> properties = Lists.newArrayList();
//
//        for (Iterator<String> keys = jsonObject.keys(); keys.hasNext();) {
//            String key = keys.next();
//            String value = jsonObject.getString(key);
//            GlanceImageProperty property = new GlanceImageProperty();
//            property.key = key;
//            property.value = value;
//            properties.add(property);
//        }
//
//        return properties;
//    }
//}
