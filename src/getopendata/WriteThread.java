/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getopendata;

/**
 *
 * @author kizax
 */
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteThread extends Thread {

    private final String record;
    private final FileWriter fileWriter;

    public WriteThread(FileWriter fileWriter, String record) {
        this.fileWriter = fileWriter;
        this.record = record;
    }

    @Override
    public void run() {
        super.run();
        try {

            byte[] ansi = record.getBytes(StandardCharsets.UTF_8);
            String recordAsciiStr = new String(ansi,StandardCharsets.ISO_8859_1);

            synchronized (fileWriter) {
                fileWriter.write(recordAsciiStr + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
