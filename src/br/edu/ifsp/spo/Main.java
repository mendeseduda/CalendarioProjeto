package br.edu.ifsp.spo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Eduardo
 */
public class Main {
    //TODO: Calendário juliano
    static FileOutputStream gregoriano;
    static FileOutputStream juliano;

    public static void main(String[] args) {
        String meses[] = new String[]{
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        int diasMeses[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        try {
            gregoriano = new FileOutputStream("gregoriano.txt");
            juliano = new FileOutputStream("juliano.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int anoInicial = 1990, diaInicial = 7;
        do {
            System.out.println("Insira o ano em que se iniciará o calendário (minímo de 1990 e máximo de 2017): ");
            anoInicial = scanner.nextInt();
        } while (anoInicial < 1990 || anoInicial > 2017);

        do {
            System.out.println("Insira o dia da semana (em inteiro) que se iniciará o ano: ");
            diaInicial = scanner.nextInt();
        } while (diaInicial < 1 || diaInicial > 7);

        try {
            //Ano
            for (int i = anoInicial; i <= 2017; i++) {
                gregoriano.write(String.format("\t\t\t\tCalendário %d\n", i).getBytes());
                gregoriano.write("+---------+---------+---------+---------+---------+---------+---------+\n".getBytes());
                diasMeses[1] = i % 4 == 0 ? 29 : 28;
                //Mês
                for (int j = 0; j < 12; j++) {
                    gregoriano.write(String.format("\t\t\t\t%s\n", meses[j]).getBytes());
                    gregoriano.write("|  seg    -   ter   -   qua   -   qui   -   sex   -   sab   -   dom   |\n".getBytes());
                    //Dia Semana
                    int cont = 1, pularLinha = 7;
                    //Dia que irá começar o mês
                    for (int k = 1; k < diaInicial; k++) {
                        gregoriano.write(String.format("%s", inserirBranco(k, 7)).getBytes());
                        pularLinha--;
                    }
                    //Dias restantes
                    for (int l = 1; l <= diasMeses[j]; l++) {
                        if (cont == pularLinha) {
                            gregoriano.write(String.format("|   %03d   |\n", l).getBytes());
                            cont = 0;
                            pularLinha = 7;
                        } else if (cont != 7) {
                            gregoriano.write(String.format("|   %03d   ", l).getBytes());
                        }
                        cont++;
                    }
                    diaInicial = cont;
                    gregoriano.write("\n+---------+---------+---------+---------+---------+---------+---------+\n\n".getBytes());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String inserirBranco(int valor, int limite) {
        StringBuilder texto = new StringBuilder();
        if (valor == limite) {
            texto.append("   \n");
        } else {
            texto.append("          ");
        }
        return texto.toString();
    }
}
