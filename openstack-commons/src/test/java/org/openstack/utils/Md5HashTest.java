package org.openstack.utils;

import java.io.ByteArrayInputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Md5HashTest {

    @Test
    public void test() throws Exception {
        String s = new String("Hello world");
        byte[] actual = Hex.fromHex("3e25960a79dbc69b674cd4ec67a72c62");

        byte[] bytes = Utf8.getBytes(s);
        byte[] hash1 = new Md5Hash().hash(s);
        byte[] hash2 = new Md5Hash().hash(bytes);
        byte[] hash3 = new Md5Hash().hash(new ByteArrayInputStream(bytes));

        Assert.assertEquals(actual, hash1);
        Assert.assertEquals(actual, hash2);
        Assert.assertEquals(actual, hash3);
    }

}
