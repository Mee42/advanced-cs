import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

// AUTHOR: CARSON GRAHAM
class Cloc {// stands for count-lines-of-code
	public static void main(String[] args){
		System.out.print("File:");
		File file = new File(new Scanner(System.in).nextLine());
		List<String> lines;
		try {
			lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("Error reading file. Please try again\n\nDebug Information:");
			e.printStackTrace();
			return;
		}
		int chars = 0;
		int words = 0;
		for(String line : lines){//this does not count newlines. hmm
			chars += line.length();
			words += line.split(" ").length;
		}
		System.out.println("characters" + chars +
				 "\nwords:" + words +
				 "\nlines:" + lines.size());
	}
}
/*
File:src/Cloc.java
characters738
words:86
lines:29


File:invaliddir/non-existant-file.txt
Error reading file. Please try again

Debug Information:
java.nio.file.NoSuchFileException: invaliddir/non-existant-file.txt
	at sun.nio.fs.UnixException.translateToIOException(UnixException.java:86)
	at sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:102)
	at sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:107)
	at sun.nio.fs.UnixFileSystemProvider.newByteChannel(UnixFileSystemProvider.java:214)
	at java.nio.file.Files.newByteChannel(Files.java:361)
	at java.nio.file.Files.newByteChannel(Files.java:407)
	at java.nio.file.spi.FileSystemProvider.newInputStream(FileSystemProvider.java:384)
	at java.nio.file.Files.newInputStream(Files.java:152)
	at java.nio.file.Files.newBufferedReader(Files.java:2784)
	at java.nio.file.Files.readAllLines(Files.java:3202)
	at Cloc.main(Cloc.java:14)
 */