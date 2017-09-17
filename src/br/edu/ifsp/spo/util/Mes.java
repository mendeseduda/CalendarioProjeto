/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de São Paulo             *
*                    Técnico Integrado em Informática                *  
*                      Projeto Integrado - Turma 213                 *
*--------------------------------------------------------------------*
*                   Autor: Eduardo Mendes R. de Faria                *
*                        data:17/09/2017                             *
*                                                                    *
*                    Id da Classe: Mes                               *
* Descrição:                                                         *
*    Classe que auxilia na geração dos calendários                   *
*--------------------------------------------------------------------*/

package br.edu.ifsp.spo.util;

public class Mes {

    public static final String MESES[] = new String[]{
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };
    public static final int DIAS_MESES[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
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
