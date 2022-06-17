import java.util.Comparator;

public class ChemicalElementComparator implements Comparator<ChemicalElement> {

    @Override
    public int compare(ChemicalElement o1, ChemicalElement o2) {
        if(o1.getSymbol().equals("C")){
            return -1;
        }else if(o2.getSymbol().equals("C")){
            return 1;
        }

        if(o1.getSymbol().equals("H")){
            return -1;
        }else if(o2.getSymbol().equals("H")){
            return 1;
        }
        else return o1.getSymbol().compareTo(o2.getSymbol());
    }
}
