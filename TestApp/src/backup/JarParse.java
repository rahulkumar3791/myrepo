package backup;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarParse {

	public static void main(String args[]) throws IOException {

		@SuppressWarnings("resource")
		JarFile jarFile = new JarFile(
				"/home/rahul/Downloads/jars/bcel-5.2.jar");
		Enumeration<JarEntry> enumm = jarFile.entries();
		while (enumm.hasMoreElements()) {
			process(enumm.nextElement());
		}
	}

	private static void process(Object obj) {
		JarEntry entry = (JarEntry) obj;
		String name = entry.getName();
		long size = entry.getSize();
		long compressedSize = entry.getCompressedSize();
		//System.out.println(name + "\t" + size + "\t" + compressedSize);
		System.out.println("Name Of Classes : "+name);
	}
}
