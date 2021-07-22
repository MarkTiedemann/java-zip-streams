import java.io.*;
import java.util.zip.*;

class Example {
	public static void main(String[] args) {
		try (var zip_stream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("a+b.zip")))) {
			for (var file : new String[] { "a.pdf", "b.pdf" }) {
				zip_stream.putNextEntry(new ZipEntry(file));
				try (var file_stream = new FileInputStream(file)) {
					var buf = new byte[4096];
					var read = 0;
					while ((read = file_stream.read(buf)) > 0) {
						zip_stream.write(buf, 0, read);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				zip_stream.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
