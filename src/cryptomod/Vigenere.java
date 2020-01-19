/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptomod;

/**
 *
 * @author jochi
 */
public class Vigenere{
    private char[][] tabel;
    private char[][] geinverteerdeTabel;
    private String sleutel;
    
    public Vigenere(String sleutel){
        this.tabel = new char['z'-'a' + 1]['z'-'a' + 1];
        this.geinverteerdeTabel = new char['z'-'a' + 1]['z'-'a' + 1];
        this.sleutel = sleutel.toLowerCase();
        
        for(int i = 0; i < tabel.length; i++){
            for(int j = 0; j < tabel[i].length; j++){
                int waarde = (i+j)%('z' - 'a' +1);
                tabel[i][j] = (char)('a' + waarde);
                char val = (char)('a' + waarde -i);
                if(val < 'a'){
                    val += ('z' - 'a' +1);
                }
                geinverteerdeTabel[i][waarde] = val;
            }
        }
        
        /*for(int i = 0; i < tabel.length; i++){
            for(int j = 0; j < tabel[i].length; j++){
                System.out.printf("%c ", tabel[i][j]);
            }
            System.out.println();
        }
        System.out.println("");
        
        for(int i = 0; i < tabel.length; i++){
            for(int j = 0; j < tabel[i].length; j++){
                System.out.printf("%c ", geinverteerdeTabel[i][j]);
            }
            System.out.println();
        }*/
    }
    
    public String encodeer(String woord){
        return codeerHelper(woord, tabel);
    }
    
    public String decodeer(String woord){
        return codeerHelper(woord, geinverteerdeTabel);
    }
    
    private String codeerHelper(String woord, char[][] mapping){
        StringBuilder versleuteldWoord = new StringBuilder();
        woord = woord.toLowerCase();
        int teller = 0;
        for(int i = 0; i < woord.length();i++){
            if(woord.charAt(i) >= 'a' && woord.charAt(i) <= 'z'){
                char letter = woord.charAt(i);
                int index = letter - 'a';
                versleuteldWoord.append(mapping[sleutel.charAt(teller)-'a'][index]);
                teller = (teller+1)%sleutel.length();
            }else{
                versleuteldWoord.append(woord.charAt(i));
            }
        }
        
        return versleuteldWoord.toString();
    }
    
    public String getSleutel(){
        return this.sleutel;
    }
    
}
