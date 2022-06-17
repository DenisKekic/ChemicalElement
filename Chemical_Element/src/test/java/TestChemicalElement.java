import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TestChemicalElement {
    private List<ChemicalElement> elements;

    @Before
    public void Setup(){
        elements = new ArrayList<>();
        elements.add(new ChemicalElement("Lithium", "Li", 3, 1.0));
        elements.add(new ChemicalElement("Zinn", "Sn", 50, 1.9));
        elements.add(new ChemicalElement("Hydrogen", "H", 1, 2.1));
        elements.add(new ChemicalElement("Oxygen", "O", 8, 3.5));
        elements.add(new ChemicalElement("Chlor", "Cl", 17, 3.0));
        elements.add(new ChemicalElement("Natrium", "Na", 11, 0.9));
        elements.add(new ChemicalElement("Kohlenstoff", "C", 6, 2.55));
        elements.add(new ChemicalElement("Titan", "Ti", 22, 1.5));
    }

    @Test
    public void testComparable(){
        Collections.sort(elements);

        assertEquals("Na", elements.get(0).getSymbol());
        assertEquals("Li", elements.get(1).getSymbol());
        assertEquals("Ti", elements.get(2).getSymbol());
        assertEquals("Sn", elements.get(3).getSymbol());
        assertEquals("H", elements.get(4).getSymbol());
        assertEquals("C", elements.get(5).getSymbol());
        assertEquals("Cl", elements.get(6).getSymbol());
        assertEquals("O", elements.get(7).getSymbol());
    }

    @Test
    public void testSerie(){
        ChemicalElement hydrogen1 = new ChemicalElement("Hydrogen", "H", 1, 2.1);
        assertFalse(hydrogen1.isAlkaliMetal());
        ChemicalElement hydrogen2 = new ChemicalElement("Hydrogen", "H", 1, 2.1);
        assertFalse(hydrogen2.isTransitionalMetal());
        ChemicalElement hydrogen3 = new ChemicalElement("Hydrogen", "H", 1, 2.1);
        assertFalse(hydrogen3.isMetal());
        ChemicalElement chlor = new ChemicalElement("Chlor", "Cl", 17, 3.0);
        assertFalse(chlor.isTransitionalMetal());
        ChemicalElement lithium = new ChemicalElement("Lithium", "Li", 3, 1.0);
        assertTrue(lithium.isAlkaliMetal());
        ChemicalElement titan = new ChemicalElement("Titan", "Ti", 22, 1.5);
        assertTrue(titan.isTransitionalMetal());
        ChemicalElement zinn = new ChemicalElement("Zinn", "Sn", 50, 1.9);
        assertTrue(zinn.isMetal());
    }

    @Test
    public void testComparator(){
        elements.sort(new ChemicalElementComparator());
        assertEquals("C", elements.get(0).getSymbol());
        assertEquals("H", elements.get(1).getSymbol());
        assertEquals("Cl", elements.get(2).getSymbol());
        assertEquals("Li", elements.get(3).getSymbol());
        assertEquals("Na", elements.get(4).getSymbol());
        assertEquals("O", elements.get(5).getSymbol());
        assertEquals("Sn", elements.get(6).getSymbol());
        assertEquals("Ti", elements.get(7).getSymbol());
    }
}