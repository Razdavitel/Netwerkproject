package cryptomod;

public class Alberti {
    private char[][] tabel;
    private char[][] geinverteerdeTabel;
    //startpositie voor welke waarde te nemen als initiele sleutel
    private int initieeleShift;
    //om de hoeveel tekens ga je telkens verschuiven
    private int schuifwaarde;
    //Met hoeveel ga je telkens verschuiven
    private int schuifhoeveelheid;
    
    public Alberti(int initieeleShift, int schuifwaarde, int schuifhoeveelheid){
        this.tabel = new char['z'-'a' + 1]['z'-'a' + 1];
        this.geinverteerdeTabel = new char['z'-'a' + 1]['z'-'a' + 1];
        this.initieeleShift = initieeleShift;
        this.schuifhoeveelheid = schuifhoeveelheid;
        this.schuifwaarde = schuifwaarde;
        
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
        int currentPos = initieeleShift;
        int teller = 0;
        for(int i = 0; i < woord.length();i++){
            if(woord.charAt(i) >= 'a' && woord.charAt(i) <= 'z'){
                char letter = woord.charAt(i);
                int index = letter - 'a';
                versleuteldWoord.append(mapping[currentPos][index]);
                teller++;
                if(teller == schuifwaarde){
                    teller = 0;
                    currentPos += schuifhoeveelheid;
                    currentPos %= mapping.length;
                }
            }else{
                versleuteldWoord.append(woord.charAt(i));
            }
        }
        
        return versleuteldWoord.toString();
    }
    
    public String getSleutel(){
        return "Initiële shift is " + initieeleShift + " - schuiven om de " + schuifwaarde + " letters - aantal schuiven per keer is " + schuifhoeveelheid + ".";
    }
}

