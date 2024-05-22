package org.example.kortos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KortuKaladė {
    List<Korta> kortuKalade;

    public KortuKaladė() {
        this.kortuKalade = getNaujaKortuKalade();
    }
    public void setKortuKalade(List<Korta> kortuKalade) {
        this.kortuKalade = kortuKalade;
    }

    public List<Korta> getKortuKalade() {
        return kortuKalade;
    }

    public void maisyti(){
        Random random = new Random();
        for(int i = 0; i < 1000; i++){
            Korta korta = kortuKalade.remove(random.nextInt(0,kortuKalade.size()-1));
            kortuKalade.add(korta);
        }

    }

    private static List<Korta> getNaujaKortuKalade(){
        List<Korta> kortuKalade = new ArrayList<>();

        for(int j = 0; j < 4; j++)
            for(int i = 0; i < 13; i++)
                kortuKalade.add(new Korta(KortosVerte.values()[i],KortosTipas.values()[j]));
        return kortuKalade;
    }

    public Korta paimtiKortaIsKalades(){
        Korta korta = kortuKalade.getLast();
        kortuKalade.removeLast();
        return korta;
    }

    public void padetiKortaIKalade(Korta korta){
        kortuKalade.add(korta);
    }
    public void padetiKortasIKalade(List<Korta> kortos){
        kortuKalade.addAll(kortos);
    }
    public void printKortas(){
        for(int i = 1; i < kortuKalade.size() +1;i++) {
            System.out.println(i +"   "+ kortuKalade.get(i-1));

        }
    }



}
