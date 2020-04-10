package com.javanetprogram.thread;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: JavaNetProgram
 * @author: liumq
 * @create: 2020-04-10 09:10
 **/
public class DigestThread extends Thread {
    private String filename;

    public DigestThread(String filename)
    {
        this.filename=filename;
    }

    @Override
    public void run() {
        //super.run();
        try{
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din  = new DigestInputStream(in,sha);
            while (din.read()!=-1) {};
            din.close();
            byte[] digest = sha.digest();

            StringBuilder result = new StringBuilder(filename);

            result.append(": ");

            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(String filename : args)
        {
            Thread t = new DigestThread(filename);
            t.start();
        }
    }
}
