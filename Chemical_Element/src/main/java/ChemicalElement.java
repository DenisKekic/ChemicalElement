public class ChemicalElement implements Comparable<ChemicalElement> {
    private final String name;
    private final String symbol;
    private final int number;
    private final double elektronegativity;
    private boolean isAlkaliMetal = false;
    private boolean isMetal = false;
    private boolean isTransitionalMetal = false;

    public ChemicalElement(String name, String symbol, int number, double elektronegativity) {
        this.name = name;
        this.symbol = symbol;
        this.number = number;
        this.elektronegativity = elektronegativity;

        detectedType();
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    public boolean isAlkaliMetal() {
        return isAlkaliMetal;
    }

    public boolean isMetal() {
        return isMetal;
    }

    public boolean isTransitionalMetal() {
        return isTransitionalMetal;
    }

    // Die Zugehörigkeit wird in der Methode detecedType im Konstruktor herausgefunden, da so viel doppelter code eingespart wird.
    // Sonst müsste man in jeder der 3 obigen Methoden jeweils den gleichen Code hineinschreiben
    // (aufgrund von den Ordnungszahlen, da diese immer durchgeprüft werden müssen)

    public void detectedType(){

        switch(number){
            case 3, 11, 19, 37, 55, 87:
                isAlkaliMetal = true;
                return;
            default:
                isAlkaliMetal = false;
                break;
        }

        if((number >= 21 && number <= 31) || (number >= 39 && number <= 48) || (number >= 72 && number <= 80) || (number >= 104 && number <= 112)){
            isTransitionalMetal = true;
            return;
        }else{
            isTransitionalMetal = false;
        }

        switch(number){
            case 13, 49, 50, 81, 82, 83, 113, 114, 115, 116:
                isMetal = true;
                return;
            default:
                isMetal = false;
        }
    }

    @Override
    public int compareTo(ChemicalElement o) {

        return Double.compare(this.elektronegativity, o.elektronegativity);
    }
}