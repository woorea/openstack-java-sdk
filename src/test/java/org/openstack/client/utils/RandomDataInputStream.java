package org.openstack.client.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RandomDataInputStream extends InputStream implements Cloneable {
    final int streamLength;
    final long seed;
    int left;

    final Random random;

    public RandomDataInputStream(int length, long seed) {
        this.streamLength = length;
        this.seed = seed;

        this.left = length;
        this.random = new Random(seed);
    }

    @Override
    public int read() throws IOException {
        byte[] buffer = new byte[1];
        int count = read(buffer);
        if (count != 1)
            return -1;
        return buffer[0] & 0xff;
    }

    @Override
    public int read(byte[] buffer) throws IOException {
        if (left == 0)
            return -1;

        int count;

        if (left >= buffer.length) {
            count = buffer.length;
            random.nextBytes(buffer);
        } else {
            count = left;
            byte[] temp = new byte[count];
            random.nextBytes(temp);
            System.arraycopy(temp, 0, buffer, 0, count);
        }
        left -= count;
        return count;
    }

    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        if (offset == 0 && length == buffer.length) {
            return read(buffer);
        }

        byte[] temp = new byte[length];
        int count = read(temp);
        if (count > 0) {
            System.arraycopy(temp, 0, buffer, offset, count);
        }
        return count;
    }

    public RandomDataInputStream clone() {
        return new RandomDataInputStream(streamLength, seed);
    }

	public int getStreamLength() {
		return streamLength;
	}

}
