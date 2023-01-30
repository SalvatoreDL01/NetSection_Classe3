package ServiziEStorage;

import java.util.Date;

public class Risposta {

    private Date dataRisposta, dataRisposto;
    private int creatoreRisposta, creatoreRisposto;

    public Risposta(Date dataRisposta, Date dataRisposto, int creatoreRisposta, int creatoreRisposto) {
        this.dataRisposta = dataRisposta;
        this.dataRisposto = dataRisposto;
        this.creatoreRisposta = creatoreRisposta;
        this.creatoreRisposto = creatoreRisposto;
    }

    public Date getDataRisposta() {
        return dataRisposta;
    }

    public void setDataRisposta(Date dataRisposta) {
        this.dataRisposta = dataRisposta;
    }

    public Date getDataRisposto() {
        return dataRisposto;
    }

    public void setDataRisposto(Date dataRisposto) {
        this.dataRisposto = dataRisposto;
    }

    public int getCreatoreRisposta() {
        return creatoreRisposta;
    }

    public void setCreatoreRisposta(int creatoreRisposta) {
        this.creatoreRisposta = creatoreRisposta;
    }

    public int getCreatoreRisposto() {
        return creatoreRisposto;
    }

    public void setCreatoreRisposto(int creatoreRisposto) {
        this.creatoreRisposto = creatoreRisposto;
    }
}
