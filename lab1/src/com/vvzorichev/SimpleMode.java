package com.vvzorichev;
 
import java.io.IOException;
 
public class SimpleMode {
 
    private String Args[];
    private String HashType;
    private String ModeType;
 
    public SimpleMode(String input[]) {
        this.Args = input;
        this.HashType = Args[0];
        this.ModeType = Args[1];
    }
 
    public void Simple() {
        switch (HashType) {
           
            case ("-md5"):
 
                if (ModeType.equals("-f")) {
                    for (int i = 2; i < Args.length; i++) {
                        String fileName = Args[i];
                        try
                        {
                            CountHash chObj = new CountHash(fileName);
                            String md5 = chObj.CountMd5();
                            System.out.println("\nFile : " + fileName + "\nMd5 : " + md5 + "\n");
                        }
                        catch (IOException ex)
                        {
                            System.out.println("File " + fileName + " does not found!\n");
                        }
                    }
                }
 
                else {
                    String fileName = Args[1];
                    try
                    {
                        CountHash chObj = new CountHash(fileName);
                        String md5 = chObj.CountMd5();
                        System.out.println("\nFile : " + fileName + "\nMd5 : " + md5 + "\n");
                    }
                    catch (IOException ex)
                    {
                        System.out.println("File " + fileName + " does not found!\n");
                    }
                }
 
                break;
                   
            case ("-sha256"):
               
                if (ModeType.equals("-f")) {
                    for (int i = 2; i < Args.length; i++) {
                        String fileName = Args[i];
                        try
                        {
                            CountHash chObj = new CountHash(fileName);
                            String sha256 = chObj.CountSha256();
                            System.out.println("\nFile : " + fileName + "\nSha256 : " + sha256 + "\n");
                        }
                        catch (IOException ex)
                        {
                            System.out.println("File " + fileName + " does not found!\n");
                        }
                    }  
                }
         
                else {
                    String fileName = Args[1];
                    try
                    {
                        CountHash chObj = new CountHash(fileName);
                        String sha256 = chObj.CountSha256();
                        System.out.println("\nFile : " + fileName + "\nSha256 : " + sha256 + "\n");
                    }
                    catch (IOException ex)
                    {
                        System.out.println("File " + fileName + " does not found!\n");
                    }
                }
 
                break;
        }
    }
}
