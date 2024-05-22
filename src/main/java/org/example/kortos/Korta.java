package org.example.kortos;

public class Korta {
    private KortosVerte kortosVerte;
    private KortosTipas kortosTipas;

    public Korta(KortosVerte kortosVerte, KortosTipas kortosTipas) {
        this.kortosVerte = kortosVerte;
        this.kortosTipas = kortosTipas;
    }

    public void setKortosVerte(KortosVerte kortosVerte) {
        this.kortosVerte = kortosVerte;
    }

    public void setKortosTipas(KortosTipas kortosTipas) {
        this.kortosTipas = kortosTipas;
    }

    public KortosVerte getKortosVerte() {
        return kortosVerte;
    }

    public KortosTipas getKortosTipas() {
        return kortosTipas;
    }

    @Override
    public String toString() {
        return  " *" + kortosVerte + " "+  kortosTipas + "* " ;
    }
}
