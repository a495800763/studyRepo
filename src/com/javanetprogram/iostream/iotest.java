package com.javanetprogram.iostream;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: JavaNetProgram
 * @author: liumq
 * @create: 2020-04-10 08:56
 **/
public class iotest {

    public static void generateCharaters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharaters = 94;
        int numberOfCharacterPerline = 72;

        int start = firstPrintableCharacter;

        while (true) {
            for (int i = start; i < start + numberOfCharacterPerline; i++) {
                out.write(((i - firstPrintableCharacter) % numberOfPrintableCharaters) + firstPrintableCharacter);
            }

            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharaters + firstPrintableCharacter;
        }
    }
}
