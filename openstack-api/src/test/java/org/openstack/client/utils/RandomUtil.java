package org.openstack.client.utils;

import java.util.Random;

public class RandomUtil {
	final Random random;

	public RandomUtil() {
		this.random = new Random();
	}

	public int uniform(int min, int max) {
		return random.nextInt(max - min) + min;
	}

	public char pick(String s) {
		return s.charAt(random.nextInt(s.length()));
	}
	
	public String randomAsciiString(int length) {
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[i] = (char) uniform(32, 127);
		}
		return new String(chars);
	}
	
	public String randomAlphanumericString(int length) {
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[i] = pick("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
		}
		return new String(chars);
	}
	
	public String randomAlphanumericString(int minLength, int maxLength) {
		int length = uniform(minLength, maxLength);
		return randomAlphanumericString(length);
	}

	public String randomAsciiString(int minLength, int maxLength) {
		int length = uniform(minLength, maxLength);
		return randomAsciiString(length);
	}

	public String randomUnicode() {
		throw new UnsupportedOperationException();
	}

	public long nextLong() {
		return random.nextLong();
	}

	public RandomDataInputStream randomStream(int maxLength) {
		int imageLength = uniform(1, maxLength);
		long seed = random.nextLong();
		return new RandomDataInputStream(imageLength, seed);
	}

}
