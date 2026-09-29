package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");

        Socket mioSocket = new Socket("127.0.0.1", 3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.print("Inserisci il tuo nome completo: ");

            String testo = scanner.nextLine();
            out.println(testo);

            if (testo.equalsIgnoreCase("exit")) {
                System.out.println("Chiusura connessione...");
                break;
            }

            String parola = in.readLine();
            System.out.println(parola);

        } while (true);

        scanner.close();
        in.close();
        out.close();
        mioSocket.close();
        System.out.println("Client chiuso.");

    }
}