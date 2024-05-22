package org.example;

import org.example.kortos.Korta;
import org.example.kortos.KortosTipas;
import org.example.kortos.KortosVerte;
import org.example.kortos.KortuKaladė;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generatorius {


    public static void paleistiUI(){
        Zaidejas z1  = new Zaidejas("Pirmas Žaidėjas");
        Zaidejas z2 = new Zaidejas("Antras Žaidėjas");
        KortuKaladė kortuKaladė = null;
        boolean dirba = true;

        while(dirba) {
            System.out.println("******************************************");
            System.out.println("Sugeneruoti kortą. (1)");
            System.out.println("Sugeneruoti  naują kortų kaladę. (2)");
            System.out.println("Maišyti kortų kaladę. (3)");
            System.out.println("Dalinti kortas. (4)");
            System.out.println("žaisti. (5)");
            System.out.println("Gražinti Kortas (6)");
            System.out.println("Keisti žaidėjų vardus (7)");
            System.out.println("Baigti Žaidimą (8)");
            System.out.println("Pasirinkimas:");
            int pasirinkimas = Custom.nuskaitytiIntVerteCon();
            switch (pasirinkimas) {
                case 1:
                    System.out.println(Generatorius.sugeneruotiRandomKorta());
                    break;
                case 2:
                    kortuKaladė = new KortuKaladė();
                    System.out.println("Kortos");
                    kortuKaladė.printKortas();
                    break;
                case 3:
                    if(kortuKaladė == null) System.out.println("Iš pradžių paimkite naują kaladę!");
                    else {
                        kortuKaladė.maisyti();
                        System.out.println("Kortos");
                        kortuKaladė.printKortas();
                    }
                    break;
                case 4:
                    if(!z1.rodytiKortas().isEmpty()) System.out.println("Kortos jau yra išdalintos, iš pradžių atiduokite kortas!");
                    else{
                        if(kortuKaladė == null) System.out.println("Pasiimkite naują kaladę");
                        else {
                            dalinti(z1, z2, kortuKaladė);
                            System.out.println("Kortos išdalintos");
                        }
                    }
                    break;
                case 5:
                    if(z1.rodytiKortas().isEmpty()) System.out.println("Žaidimas be kortu nėra įdomus!");
                    else{
                        Zaidejas laimetojas = zaisti(z1,z2);
                        System.out.println("Laimetojas:");
                        if(laimetojas == null) System.out.println("Lygios");
                        else System.out.println(laimetojas);
                    }
                    break;
                case 6:
                    if(kortuKaladė == null) System.out.println("Nėra, ką gražinti");
                    else {
                        grazintiKortas(z1,z2,kortuKaladė);
                        System.out.println("Kortos gražintos");
                        break;
                    }

                case 7:
                    System.out.println("Iveskite pirmo žaidėjo vardą:");
                    z1.setVardas(Custom.nuskaitytiStringVerteCon());
                    System.out.println("Iveskite antro žaidėjo vardą:");
                    z2.setVardas(Custom.nuskaitytiStringVerteCon());
                    break;
                case 8:
                    dirba = false;
                    break;
            }
        }
    }

    public static Korta sugeneruotiRandomKorta(){
        Random random = new Random();
        Korta korta = new Korta(KortosVerte.values()[random.nextInt(0,12)], KortosTipas.values()[random.nextInt(0,3)]);
        return korta;
    }

    public static void dalinti(Zaidejas z1, Zaidejas z2, KortuKaladė kortuKaladė){
            z1.gautiKorta(kortuKaladė.paimtiKortaIsKalades());
            z2.gautiKorta(kortuKaladė.paimtiKortaIsKalades());
            z1.gautiKorta(kortuKaladė.paimtiKortaIsKalades());
            z2.gautiKorta(kortuKaladė.paimtiKortaIsKalades());
    }

    public static Zaidejas zaisti(Zaidejas z1, Zaidejas z2){

        int taskaiZ1 = skaiciuotiTaskus(z1);
        int taskaiZ2 = skaiciuotiTaskus(z2);
        System.out.println(z1);
        System.out.println("Taškai: " + skaiciuotiTaskus(z1));
        System.out.println(z2);
        System.out.println("Taškai: " + skaiciuotiTaskus(z2));

        if (taskaiZ1 == taskaiZ2) return null;
        return taskaiZ1 > taskaiZ2 ? z1 : z2;

    }

    public static void grazintiKortas(Zaidejas z1, Zaidejas z2, KortuKaladė kortuKaladė){
        List<Korta> grazinamosKortos = new ArrayList<>();
        grazinamosKortos.addAll(z1.atiduotiKortas());
        grazinamosKortos.addAll(z2.atiduotiKortas());
        kortuKaladė.padetiKortasIKalade(grazinamosKortos);
    }

    private static int skaiciuotiTaskus(Zaidejas z){
        List<Korta> turimosZaidejoKortos = z.rodytiKortas();
        int taskai = 0;
        for(int i = 0; i< turimosZaidejoKortos.size(); i++){

            if(                turimosZaidejoKortos.get(i).getKortosVerte().ordinal() <= 8)
                taskai+=turimosZaidejoKortos.get(i).getKortosVerte().ordinal()+2;

            else if (          turimosZaidejoKortos.get(i).getKortosVerte().ordinal() > 8
                            && turimosZaidejoKortos.get(i).getKortosVerte().ordinal() < 12 )
                taskai+=10;
            else
                taskai+=11;

        }
        //if(taskai == 22) taskai = 21;

        return taskai;
    }


}
