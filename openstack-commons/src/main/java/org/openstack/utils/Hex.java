package org.openstack.utils;

public class Hex {
    public static String toHex(byte[] bytes) {
        return toHex(bytes, 0, bytes.length);
    }

    public static byte[] fromHex(String hexString) {
        if (hexString == null) {
            return null;
        }

        int len = hexString.length();
        if (len % 2 != 0) {
            throw new IllegalArgumentException();
        }

        byte[] data = new byte[len / 2];
        for (int i = 0; i < data.length; i++) {
            // String hexByte = hexString.substring(i * 2, i * 2 + 2);
            //
            // Integer num = Integer.decode("0x" + hexByte);
            // data[i] = num.byteValue();
            data[i] = (byte) (Integer.parseInt(hexString.substring(i * 2, i * 2 + 2), 16) & 0xff);
        }

        return data;
    }

    public static String toHex(byte[] bytes, int offset, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = offset; i < offset + length; i++) {
            String s = Integer.toHexString(bytes[i] & 0xff);
            if (s.length() == 1) {
                sb.append('0');
            }
            sb.append(s);
        }
        return sb.toString();
    }

    public static String toHex(byte b) {
        String s = Integer.toHexString(b & 0xff);
        if (s.length() == 1) {
            return "0" + s;
        }
        return s;
    }

}
