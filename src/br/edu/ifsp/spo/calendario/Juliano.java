/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de São Paulo             *
*                    Técnico Integrado em Informática                *  
*                      Projeto Integrado - Turma 213                 *
*--------------------------------------------------------------------*
*                   Autor: Eduardo Mendes R. de Faria                *
*                        data:17/09/2017                             *
*                                                                    *
*                    Id da Classe: Juliano                           *
* Descrição:                                                         *
*    Classe que será responsável por gerar o calendário Juliano      *
*--------------------------------------------------------------------*/

package br.edu.ifsp.spo.calendario;

import br.edu.ifsp.spo.util.Mes;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Juliano {

    static FileOutputStream juliano;

    static {
        try {
            juliano = new FileOutputStream("juliano.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void gerarJuliano(int anoInicial, int diaInicial) {
        try {
            //Ano
            for (int i = anoInicial; i <= 2017; i++) {
                int diaAno = 1;
                juliano.write(String.format("\t\t\t\tCalendário %d\n", i).getBytes());
                juliano.write("+---------+---------+---------+---------+---------+---------+---------+\n".getBytes());
                Mes.DIAS_MESES[1] = i % 4 == 0 ? 29 : 28;
                //Mês
                for (int j = 0; j < 12; j++) {
                    juliano.write(String.format("\t\t\t\t%s\n", Mes.MESES[j]).getBytes());
                    juliano.write("|  seg    -   ter   -   qua   -   qui   -   sex   -   sab   -   dom   |\n".getBytes());
                    //Dia Semana
                    int cont = 1, pularLinha = 7;
                    //Dia que irá começar o mês
                    for (int k = 1; k < diaInicial; k++) {
                        juliano.write(String.format("%s", Mes.inserirBranco(k, 7)).getBytes());
                        pularLinha--;
                    }
                    //Dias restantes
                    for (int l = 1; l <= Mes.DIAS_MESES[j]; l++) {
                        if (cont == pularLinha) {
                            juliano.write(String.format("|   %03d   |\n", diaAno).getBytes());
                            cont = 0;
                            pularLinha = 7;
                        } else if (cont != 7) {
                            juliano.write(String.format("|   %03d   ", diaAno).getBytes());
                        }
                        diaAno++;
                        cont++;
                    }

                    diaInicial = cont;
                    juliano.write("\n+---------+---------+---------+---------+---------+---------+---------+\n\n".getBytes());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
