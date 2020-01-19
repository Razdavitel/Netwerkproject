
package cryptomod;

public class CryptoMod {


    public static void main(String[] args) {
        Caesar caesar = new Caesar(2);
        String zin = "Uitzonderlijke nieuwe opening op zondag";
        String geencodeerd = caesar.encodeer(zin);
        
        System.out.println(geencodeerd);
        
        System.out.println(caesar.decodeer(geencodeerd));
        System.out.println();
        caesar.bruteForce(geencodeerd);
        
        
        //
        CaesarAdvanced caesarAdvanced = new CaesarAdvanced();
        System.out.printf("\n\n\nCaesarAdvanced (met sleutel: %s)\n", caesarAdvanced.getSleutel());
        geencodeerd = caesarAdvanced.encodeer(zin);
        
        System.out.println(geencodeerd);
        
        System.out.println(caesarAdvanced.decodeer(geencodeerd));
        System.out.println();
        
        //om de 2 letters verschuift het 3 letters
       // Alberti alberti = new Alberti(2,3);
       // System.out.println(alberti.encodeer("de pelikaan is een magnifiek wezen waarvan ik niet weet waar het op aarde leeft"));
       
        Alberti alberti = new Alberti(0, 2, 3);
       
        System.out.printf("\n\n\nAlberti (met sleutel: %s)\n", alberti.getSleutel());
        
        geencodeerd = alberti.encodeer(zin);
        
        System.out.println(geencodeerd);
        
        System.out.println(alberti.decodeer(geencodeerd));
        System.out.println();
        
        Vigenere vigenere = new Vigenere("jochim");
       
        System.out.printf("\n\n\nVigenère (met sleutel: %s)\n", vigenere.getSleutel());
        
        geencodeerd = vigenere.encodeer("pelikaan");
        
        System.out.println(geencodeerd);
        
        System.out.println(vigenere.decodeer(geencodeerd));
        System.out.println();
        
        
        FrequentieAnalyse frequentieAnalyse = new FrequentieAnalyse();
        frequentieAnalyse.analyseer("De achterlijke pelikaan vliegt snel door de bossen xxxxx yyyyyy");
        
        System.out.println("\nPlayFair");
        
        PlayFair playfair = new PlayFair("jochim");
        System.out.println("");
        
        System.out.println("Test normaal");
        System.out.println(playfair.encodeer("pelikaan"));
        System.out.println(playfair.decodeer(playfair.encodeer("pelikaan")));
        System.out.println("");
        System.out.println("Test oneven aantal letters");
        System.out.println(playfair.encodeer("pelikanen"));
        System.out.println(playfair.decodeer(playfair.encodeer("pelikanen")));
        System.out.println("");
        System.out.println("Test dubbele letters");
        System.out.println(playfair.encodeer("balloon"));
        System.out.println(playfair.decodeer(playfair.encodeer("balloon")));
        
        System.out.println("Test woord");
        System.out.println(playfair.encodeer("gewerkt"));

    }
    
}
