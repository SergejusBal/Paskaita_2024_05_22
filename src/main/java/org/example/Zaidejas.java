package org.example;

import org.example.kortos.Korta;

import java.util.ArrayList;
import java.util.List;

public class Zaidejas {
    List<Korta> kortos;
    private String vardas;

    public Zaidejas(String vardas) {
        this.vardas = vardas;
        kortos = new ArrayList<>();
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void gautiKorta(Korta korta) {
        kortos.add(korta);
    }
    public List<Korta> rodytiKortas(){
        return kortos;
    }
    public List<Korta> atiduotiKortas(){
        List<Korta> grazinamosKortos = new ArrayList<>(kortos);
        kortos.clear();
        return grazinamosKortos;
    }

    @Override
    public String toString() {
        return vardas + "   Kortos:  " + kortos.get(0) + "  " + kortos.get(1);
    }
}
