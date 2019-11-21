package com.vvzorichev;
 
import java.io.IOException;
import java.util.Scanner;
 
public class InteractiveMode {
 
    private String Args[];
 
    public InteractiveMode(String input[]) {
        this.Args = input;
    }
 
    private void PrintHash(String fileName) {
        try
        {
            CountHash chObj = new CountHash(fileName);
            String md5 = chObj.CountMd5();
            String sha256 = chObj.CountSha256();
            System.out.println("\nFile : " + fileName + "\nMd5 : " + md5 + "\nSha256 : " + sha256 + "\n");
        }
        catch (IOException ex)
        {
            System.out.println("File " + fileName + " does not found!\n");
        }
    }
 
    public void Interactive() {
        boolean stop = false;
        while (!stop) {
            System.out.println("Enter file / files names:");
            Scanner input = new Scanner(System.in);
            for (String str : input.nextLine().split(" ")) {
                PrintHash(str);
            }
            boolean answer = false;
            while (!answer) {
                System.out.println("Do you want to count hash of another files?\n1 - Yes\n2 - No");
                String response = input.next();
                switch(response){
 
                    case "2":
                        stop = true;
                        answer = true;
                        break;
 
                    case "1":
                        answer = true;
                        break;
                   
                    default:
                        System.out.println("Incorrect answer! Try again");
                        break;
                }
            }
        }
    }
}
