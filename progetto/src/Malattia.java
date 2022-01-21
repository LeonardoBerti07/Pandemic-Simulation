public class Malattia {

    public int infettività;
    public int sintomaticità;
    public int letalità;
    public int durata;
    public int incubazione;

    public Malattia(int infettività, int sintomaticità,int letalità, int durata){ //costruiamo la malattia
        this.infettività = infettività;
        this.sintomaticità = sintomaticità;
        this.letalità = letalità;
        this.durata = durata;
        int incubazione = durata/6;
        this.incubazione = incubazione;
    }

    public int getInfettività() {
        return infettività;
    } //ritorna il grado di infettività

    public int getIncubazione() { //ritorna in che giorno finisce il periodo di incubazione
        return incubazione;
    }
}
