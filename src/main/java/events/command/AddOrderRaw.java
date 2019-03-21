package events.command;

import bus.BusMessage;

import java.util.UUID;

public class AddOrderRaw implements BusMessage {

    private UUID idordine;
    private String descrizione;
    private Integer valore;

    public AddOrderRaw() {
    }

    public UUID getIdordine() {
        return idordine;
    }

    public void setIdordine(UUID idordine) {
        this.idordine = idordine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getValore() {
        return valore;
    }

    public void setValore(Integer valore) {
        this.valore = valore;
    }

    public void build(UUID idordine, String descrizione, Integer valore) {
        this.idordine = idordine;
        this.descrizione = descrizione;
        this.valore = valore;
    }
}
