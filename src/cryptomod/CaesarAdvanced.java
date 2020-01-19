package cryptomod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaesarAdvanced {
    
    private char[] sleutel;
    private char[] geïnverteerdeSleutel;
    
    public CaesarAdvanced(){
        this.sleutel = new char['z'-'a' + 1];
        this.geïnverteerdeSleutel = new char['z'-'a' + 1];
        
        List<Character> temp = new ArrayList();
        for(int i = 0; i < sleutel.length;i++){            
            temp.add((char)(i + 'a'));
        }
        Collections.shuffle(temp);
        for(int i = 0; i < sleutel.length;i++){
            sleutel[i] = temp.get(i);
            geïnverteerdeSleutel[temp.get(i) - 'a'] = (char)(i + 'a');
        }
    }
    
    public String encodeer(String woord){
        return codeerHelper(woord, sleutel);
    }
    
    public String decodeer(String woord){
        return codeerHelper(woord, geïnverteerdeSleutel);
    }
    
    private String codeerHelper(String woord, char[] mapping){
        StringBuilder versleuteldWoord = new StringBuilder();
        woord = woord.toLowerCase();
        
        for(int i = 0; i < woord.length();i++){
            if(woord.charAt(i) >= 'a' && woord.charAt(i) <= 'z'){
                char letter = woord.charAt(i);
                int index = letter - 'a';
                versleuteldWoord.append(mapping[index]);
            }else{
                versleuteldWoord.append(woord.charAt(i));
            }
        }
        
        return versleuteldWoord.toString();
    }
    
    public String getSleutel(){
        StringBuilder resultaat = new StringBuilder();

        for(int i = 0;i < sleutel.length; i++){
            resultaat.append(sleutel[i]);
        }
        return resultaat.toString();
    }
}
