package pl.pstefaniak.zeus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileLockExample {
    public static void main(String[] args) throws IOException {
        String input = "Demo text to be written in locked mode.";
        System.out.println("Input string to the test file is: " + input);
        ByteBuffer buf = ByteBuffer.wrap(input.getBytes());
        String fp = "d:/temp/file.txt";
        Path pt = Paths.get(fp);
        FileChannel channel = FileChannel.open(pt, StandardOpenOption.WRITE,StandardOpenOption.APPEND);
        channel.position(channel.size() - 1); // position of a cursor at the end of file
        FileLock lock = channel.lock();
        System.out.println("The Lock is shared: " + lock.isShared());
        channel.write(buf);
        channel.close(); // Releases the Lock
        System.out.println("Content Writing is complete. Therefore close the channel and release the lock.");
        PrintFileCreated.print(fp);
    }
}

class PrintFileCreated {
   public static void print(String path) throws IOException {
       FileReader filereader = new FileReader(path);
       BufferedReader bufferedreader = new BufferedReader(filereader);
       String tr = bufferedreader.readLine();
       System.out.println("The Content of testout.txt file is: ");
       while (tr != null) {
           System.out.println("    " + tr);
           tr = bufferedreader.readLine();
       }
       filereader.close();
       bufferedreader.close();
   }
}