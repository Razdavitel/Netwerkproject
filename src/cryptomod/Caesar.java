
package cryptomod;


public class Caesar {
    
    private int sleutel;
    private char[] encodeerMapping;
    private char[] decodeerMapping;
    
    public Caesar(int sleutel){
        this.sleutel = sleutel;
        this.encodeerMapping = new char['z'-'a' + 1];
        this.decodeerMapping = new char['z'-'a' + 1];
        
        for(int i = 0; i < encodeerMapping.length;i++){
            int waarde = (i + sleutel)% encodeerMapping.length;
            
            encodeerMapping[i] = (char)(waarde + 'a');
            decodeerMapping[waarde] = (char)('a'+ i);
        }
    }
    
    public String encodeer(String woord){
        return codeerHelper(woord, encodeerMapping);
    }
    
    public String decodeer(String woord){
        return codeerHelper(woord, decodeerMapping);
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
    
    public void bruteForce(String woord){
        System.out.println("Bruteforcing");
        //Voor de eenvoud wordt er vanuitgegaan dat de zin geëncodeerd (niet leesbaar) is.
        //Hierom wordt de mapping naar dezelfde letters overgeslagen.
        char[] mapping = new char['z' - 'a' + 1];
        
        for(int i = 1; i <= 'z' - 'a'; i++){          
            for(int j = 0; j < mapping.length;j++){
                int waarde = (j + i)% mapping.length;

                mapping[j] = (char)(waarde + 'a');
            }
            System.out.printf("Poging %d: %s\n", i, codeerHelper(woord, mapping));
        }
    }
}
