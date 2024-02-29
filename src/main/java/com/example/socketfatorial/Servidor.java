package com.example.socketfatorial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(40000)) {
            while (true) {
                try (Socket conexao = servidor.accept();
                     ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
                     ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream())) {

                    double numero = entrada.readDouble();
                    double resultado = 1;
                    double contador = numero;

                    while (contador > 1) {
                        resultado = resultado * contador;
                        contador = contador - 1;
                    }

                    double fatorial = resultado;
                    saida.writeDouble(fatorial);
                    saida.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





