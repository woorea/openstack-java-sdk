//package org.openstack.model.image;
//
//import java.util.Iterator;
//import java.util.List;
//
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.google.common.collect.Lists;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement
//public class GlanceImageList implements Iterable<Image> {
//    public List<Image> images = Lists.newArrayList();
//
//    @Override
//    public Iterator<Image> iterator() {
//        return images.iterator();
//    }
//
//    public static GlanceImageList deserialize(JSONObject json) throws JSONException {
//        GlanceImageList ret = new GlanceImageList();
//        JSONArray images = json.getJSONArray("images");
//        for (int i = 0; i < images.length(); i++) {
//            ret.images.add(Image.deserialize(images.getJSONObject(i)));
//        }
//        return ret;
//    }
//}
