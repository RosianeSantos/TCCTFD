/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Utilizados;

import java.util.Random;

/**
 *Classe do Site http://www.guj.com.br/java/67904-gerador-de-senha-alfanumerico.
 * @author Rosy
 */
public class CodigoAlfaNum {
    /**
     * Cria um codigo AlfaNumerico, com numeros variando de 0 a 9, e letras variando
     * de "a" a "z" e "A" a "Z".
     * @param len tamanho do codigo a ser gerado em int.
     * @return 
     */
    public String gerarCodigoMaiusculasMinusculas(int len){
        char[] chart ={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        char[] senha= new char[len];

        int chartLenght = chart.length;
        Random rdm = new Random();

        for (int x=0; x<len; x++)
        senha[x] = chart[rdm.nextInt(chartLenght)];

        return new String(senha);
    }
    
    /**
     * Cria um codigo AlfaNumerico, com numeros variando de 0 a 9, e letras variando
     * de "A" a "Z".
     * @param len tamanho do codigo a ser gerado em int.
     * @return 
     */
        public String gerarCodigoMaiusculas(int len){
        char[] chart ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        char[] senha= new char[len];

        int chartLenght = chart.length;
        Random rdm = new Random();

        for (int x=0; x<len; x++)
        senha[x] = chart[rdm.nextInt(chartLenght)];

        return new String(senha);
    }
}
