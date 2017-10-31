/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author Gustavo Mendonça
 */
public class ValidaControl {
    public boolean cpfValida(String cpf){
        
        if (cpf.equals("000.000.000-00") || cpf.equals("111.111.111-11") ||
        cpf.equals("222.222.222-22") || cpf.equals("333.333.333-33") ||
        cpf.equals("444.444.444-44") || cpf.equals("555.555.555-55") ||
        cpf.equals("666.666.666-66") || cpf.equals("777.777.777-77") ||
        cpf.equals("888.888.888-88") || cpf.equals("999.999.999-99")){
            return(false);
        }
        
        char dig10, dig11;
        int sm, i, r, num, peso;
        
        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i=0; i<11; i++) {              
            if((i == 3) || (i == 7)){
                
            }
            else {
                num = (int)(cpf.charAt(i) - 48); 
                sm = sm + (num * peso);
                peso = peso - 1;
            }
        
        }
        
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
        System.out.println(dig10);
        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for(i=0; i<13; i++) {
            if((i == 3) || (i == 7) || (i == 11)){
                
            }
            else {
                num = (int)(cpf.charAt(i) - 48); 
                sm = sm + (num * peso);
                peso = peso - 1;
            }
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else dig11 = (char)(r + 48);
        System.out.println(dig11);
        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == cpf.charAt(12)) && (dig11 == cpf.charAt(13)))
            return(true);
        else return(false);
    }
}
