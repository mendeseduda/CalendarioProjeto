/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de São Paulo             *
*                    Técnico Integrado em Informática                *  
*                      Projeto Integrado - Turma 213                 *
*--------------------------------------------------------------------*
*                   Autor: Eduardo Mendes R. de Faria                *
*                        data:17/09/2017                             *
*                                                                    *
*                    Id da Classe: Main                              *
* Descrição:                                                         *
*    Classe que receberá os dados do usuário e ira executar as       *
* classes de calendários.                                            *
*--------------------------------------------------------------------*/

package br.edu.ifsp.spo;

import br.edu.ifsp.spo.calendario.Gregoriano;
import br.edu.ifsp.spo.calendario.Juliano;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anoInicial = 2016, diaInicial = 1;
        do {
            System.out.println("Insira o ano em que se iniciará o calendário (minímo de 1990 e máximo de 2017): ");
            anoInicial = scanner.nextInt();
        } while (anoInicial < 1990 || anoInicial > 2017);

        do {
            System.out.println("Insira o dia da semana (em inteiro) que se iniciará o ano: ");
            diaInicial = scanner.nextInt();
        } while (diaInicial < 1 || diaInicial > 7);

        Gregoriano.gerarGregoriano(anoInicial, diaInicial);
        Juliano.gerarJuliano(anoInicial, diaInicial);
    }
}
