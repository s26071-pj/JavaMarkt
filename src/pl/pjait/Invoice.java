package pl.pjait;

import java.util.ArrayList;

public class Invoice {

    private ArrayList<InvoicePosition> positions = new ArrayList<>();

    public ArrayList<InvoicePosition> getPositions(){
        return positions;
    }
    public void addPosition(InvoicePosition position){
        position.add(position);
    }
}
