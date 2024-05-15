package org.example;

import java.io.IOException;
import java.util.Scanner;

import static org.example.Utils.*;

public class HttpImageStatusCli {
    public void askStatus() throws Exception {
        try(Scanner console = new Scanner(System.in)){
            System.out.println(ENTER_HTTP_STATUS_CODE);
            while (!console.hasNextInt()){
                System.out.println(String.format(ENTER_VALID_NUMBER));
                console.next();
            }
            int codeFromUser = console.nextInt();
            try {
                new HttpStatusImageDownloader().downloadStatusImage(codeFromUser);
                System.out.println(String.format(FILE_ALREADY_DOWNLOADED, codeFromUser));
            } catch (IOException e) {
                System.out.println(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, codeFromUser));
            }
        }

    }

    public static void main(String[] args) throws Exception {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
