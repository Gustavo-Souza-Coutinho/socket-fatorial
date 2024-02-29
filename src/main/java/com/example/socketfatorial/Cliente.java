package com.example.socketfatorial;


import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        double numero = Double.parseDouble(JOptionPane.showInputDialog("Digite o numero para fatoralo:"));

        try (Socket conexao = new Socket("127.0.0.1", 40000)) {

            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());


            saida.writeDouble(numero);
            saida.flush();

            double fatorial = entrada.readDouble();

            JOptionPane.showMessageDialog(null, "Seu fatorial é: " + fatorial);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
