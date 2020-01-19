
package cryptomod;

public class FrequentieAnalyse {
    
    private String invoer;
    private int[] analyse;
    
    public FrequentieAnalyse(){
        this.invoer = invoer;
        this.analyse = new int['z'-'a' + 1];
    }
    
    public void analyseer(String invoer){
        this.invoer = invoer;
        invoer = invoer.toLowerCase();
        
        int positie = 0;
        int waarde = 0;
        for(int i = 0; i < invoer.length() ; i++){
           if(invoer.charAt(i) >= 'a' && invoer.charAt(i) <= 'z'){
                waarde = (int) invoer.charAt(i);
                positie = waarde % 'z'-'a';
                analyse[positie]++;
           }
        }
         for(int i = 0 ; i < analyse.length; i++){
            System.out.println(analyse[i]);
        }
    }
}
