package commandstorage;

import java.util.UUID;

public class OrderRaw {
    private int id;
    private UUID idordine;
    private String descrizione;
    private Integer valore;

    public OrderRaw() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public OrderRaw(UUID idordine, String descrizione, Integer valore) {
        this.idordine = idordine;
        this.descrizione = descrizione;
        this.valore = valore;
    }
}
