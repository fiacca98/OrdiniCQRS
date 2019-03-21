package projectionstorage;

import java.util.UUID;

public class OrderNumber {

    private String nomeRichiedente;

    private int Count;

    public OrderNumber(String nomeRichiedente, int count) {
        this.nomeRichiedente = nomeRichiedente;
        Count = count;
    }

    public String getNomeRichiedente() {
        return nomeRichiedente;
    }

    public void setNomeRichiedente(String nomeRichiedente) {
        this.nomeRichiedente = nomeRichiedente;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}
