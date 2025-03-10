import java.util.HashSet;

public class Symbol {
    private HashSet<String> symbols = new HashSet<>();

    public void setSymbols(String value){
        String[] values = value.split(" ");
        for (String val : values) {
            if (!symbols.contains(val)) {
                symbols.add(val);
            }
            else{System.out.println("'"+val+"' has already declared!");}
        }
    }
    public void getSymbols(){
        System.out.print("Declerad symbols:");
        for (String s : symbols) {
            System.out.print(","+s);
        }
        System.out.println();
    }
}
