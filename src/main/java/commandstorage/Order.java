package commandstorage;

import bus.BusMessage;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private String nomeRichiedente;
    private Date data;
    private List<OrderRaw> orderRaws = new ArrayList<OrderRaw>();

    public Order() {
    }

    public Order(UUID id, String nomeRichiedente, Date data) {
        this.id = id;
        this.nomeRichiedente = nomeRichiedente;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeRichiedente() {
        return nomeRichiedente;
    }

    public void setNomeRichiedente(String nomeRichiedente) {
        this.nomeRichiedente = nomeRichiedente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


}
