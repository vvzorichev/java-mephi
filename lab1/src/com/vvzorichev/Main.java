package com.vvzorichev;
 
public class Main {
    public static void main(String[] args) {
        switch (args[0]) {         
           
            case "-i":
                InteractiveMode imObj = new InteractiveMode(args);
                imObj.Interactive();
                break;
 
            default:
                SimpleMode smObj = new SimpleMode(args);
                smObj.Simple();
                break;
        }
    }
}
