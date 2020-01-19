
package cryptomod;

import java.util.ArrayList;
import java.util.List;

public class PlayFair {
    private char[][] mapping;
    private String sleutel;
    List<Character> karakters = new ArrayList<>();
    int rij = 0;
    int kolom;
    int teller;
    
    public PlayFair(String s){
        this.mapping = new char[5][5];
        this.sleutel = s.toLowerCase();
        
        for(int i = 0; i < 'z'-'a'; i++){
            karakters.add((char)('a'+i));
        }
        for(int i = 0 ; i < sleutel.length(); i++){
            if(karakters.contains(sleutel.charAt(i))){  
                karakters.remove((Character)sleutel.charAt(i));
                rij = teller / mapping.length;
                kolom = teller % mapping.length;
                mapping[rij][kolom] = sleutel.charAt(i);
                teller++;
            }
        }
        for(int i = 0; i < karakters.size(); i++){
            rij = teller / mapping.length;
            kolom = teller % mapping.length;
            mapping[rij][kolom] = karakters.get(i);
            teller++;
        }
        
        for(int i = 0; i < mapping.length; i++){
           for(int j = 0; j < mapping[i].length; j++){
                System.out.printf("%c ", mapping[i][j]);
            }
            System.out.println();
        }
        
        
    }
    
    public String encodeer(String woord){
        int rijC1 = 0;
        int rijC2 = 0;
        int kolomC1 = 0;
        int kolomC2 = 0;
        String versleuteld="";
        
        //Als het woord een oneven aantal letters bevat, voeg X toe
        if(woord.length()%2 != 0){
            woord += 'x';
        }
        
        for(int i = 0; i < woord.length(); i+=2){ //per 2 stappen omdat we per 2 encoderen
            char eersteChar = woord.charAt(i);
            char tweedechar = woord.charAt(i+1);
            int[] coördinatenEersteChar;
            int[] coördinatenTweedeChar;
            
            if (eersteChar == tweedechar){
                tweedechar = 'x';
            }
            
            coördinatenEersteChar = vindCoördinaat(eersteChar);
            coördinatenTweedeChar = vindCoördinaat(tweedechar);
            
            rijC1 = coördinatenEersteChar[0];
            kolomC1 = coördinatenEersteChar[1];
            rijC2 = coördinatenTweedeChar[0];
            kolomC2 = coördinatenTweedeChar[1];
            
            //Als rijen gelijk, shift !!!KOLOM!!! naar rechts
            if(rijC1 == rijC2){
                kolomC1 = (kolomC1 + 1) % 5;
                kolomC2 = (kolomC2 + 1) % 5;
            }else //zonder deze else werd dit niet gedaan
            //Als kolommen gelijk, shift !!!RIJ!!! naar beneden
            if(kolomC1 == kolomC2){
                rijC1 = (rijC1 + 1) % 5;
                rijC2 = (rijC2 + 1) % 5;
            }
            else{
                //Als je vierkant kan vormen !!! KOLOMMEN !!! omwisselen
                int temp = kolomC1;
                kolomC1 = kolomC2;
                kolomC2 = temp;
            }
            
            versleuteld += mapping[rijC1][kolomC1];
            versleuteld += mapping[rijC2][kolomC2];
        }
        
        return versleuteld;
    }
    
    public String decodeer(String versleuteldWoord){
        int rijC1 = 0;
        int rijC2 = 0;
        int kolomC1 = 0;
        int kolomC2 = 0;
        String ontcijferd="";
        
        for(int i = 0; i < versleuteldWoord.length(); i+=2){
            char eersteChar = versleuteldWoord.charAt(i);
            char tweedechar = versleuteldWoord.charAt(i+1);
            int[] coördinatenEersteChar;
            int[] coördinatenTweedeChar;
            
            coördinatenEersteChar = vindCoördinaat(eersteChar);
            coördinatenTweedeChar = vindCoördinaat(tweedechar);
            
            rijC1 = coördinatenEersteChar[0];
            kolomC1 = coördinatenEersteChar[1];
            rijC2 = coördinatenTweedeChar[0];
            kolomC2 = coördinatenTweedeChar[1];
            
            if(rijC1 == rijC2){
                kolomC1 = (kolomC1 + 4) % 5; // +4 want java is geen fan van modulo met negatieve getallen
                kolomC2 = (kolomC2 + 4) % 5;
            }else
            if(kolomC1 == kolomC2){
                rijC1 = (rijC1 + 4) % 5; 
                rijC2 = (rijC2 + 4) % 5;
            }
            else{
                int temp = kolomC1;
                kolomC1 = kolomC2;
                kolomC2 = temp;
            }
            
            ontcijferd += mapping[rijC1][kolomC1];
            ontcijferd += mapping[rijC2][kolomC2];
        }
        
        return ontcijferd;
    }
    
    //kan gebruikt worden voor encoderen en decoderen
    private int[] vindCoördinaat(char c){
        //Hier ga ik niet trots op zijn...
        int[] coördinaten = new int[2];
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(c == mapping[i][j]){
                    coördinaten[0] = i;
                    coördinaten[1] = j;
                }
            }  
        }
        return coördinaten;
    }
    
}
