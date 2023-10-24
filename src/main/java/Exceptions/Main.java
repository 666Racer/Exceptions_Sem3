package Exceptions;

import java.io.*;
import java.nio.file.Path;

/*private void rwLine(Path pathRead, Path pathWrite) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
           in = new BufferedReader(in);
           out = new BufferedWriter(out);
           out.write(in.readLine());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e){

            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e){

            }
        }
    }
 */

public class Main {
    private static void rwLine(Path pathRead, Path pathWrite) throws IOException {
        //BufferedReader in = null;
        //BufferedWriter out = null;

        try (BufferedReader in = new BufferedReader(new FileReader(pathRead.toFile()));
             BufferedWriter out = new BufferedWriter(new FileWriter(pathWrite.toFile()))) {
            out.write(in.readLine());
        }
    }
    public static void main(String[] args) throws IOException {
        rwLine(Path.of("pom.xml"), Path.of("test"));
    }
}

