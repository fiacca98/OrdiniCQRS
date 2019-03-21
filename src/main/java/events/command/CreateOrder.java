package events.command;

import bus.BusMessage;

import java.sql.Date;

public class CreateOrder implements BusMessage {
    private String nomeRichiedente;
    private Date data;

    public CreateOrder() {
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

    public void build(String nomeRichiedente, Date data) {
        this.nomeRichiedente = nomeRichiedente;
        this.data = data;
    }
}
