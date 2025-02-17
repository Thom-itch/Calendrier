import java.util.Scanner;
public class Date {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    public Date(int parJ, int parM, int parA) {
        chJour = parJ;
        chMois = parM;
        chAnnee = parA;
    }

    /**
     *
     * @return
     */
    public Date(int parAnnee) {
        chJour = 01;
        chMois = 01;
        chAnnee = parAnnee;
    }

    public Date() {}

    /**
     *
     * @return
     */
    private static int dernierJourDuMois (int parM, int parA) {
        switch (parM) {
            case 2 : if (estBissextile(parA))
                return 29;
                return 28;
            case 4: case 6: case 9: case 11: return 30;
            default : return 31;
        }
    }

    /**
     *
     * @return
     */
    private static boolean estBissextile(int parA) {
        return parA%400 == 0 || (parA%4 == 0 && parA%100 !=0);
    }

    /**
     *
     * @return
     */
    public boolean estValide() {
        if (chAnnee > 1582)
            if (chMois >= 1 && chMois <= 12)
                if (chJour >= 1 && chJour <= dernierJourDuMois(chMois,chAnnee) )
                    return true;
        return false;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return chJour+"/"+chMois+"/"+chAnnee;
    }

    /**
     *
     * @return
     */
    public static Date lireDate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Rentrer le jour");
        int jour = scan.nextInt();
        System.out.println("Rentrer le mois");
        int mois = scan.nextInt();
        System.out.println("Rentrer l'annee ");
        int annee = scan.nextInt();
        return new Date(jour,mois,annee);
    }

    /**
     *
     * @return
     */
    public Date dateDuLendemain() {
        Date dateLendemain = new Date(chJour+1, chMois, chAnnee);
        if (dateLendemain.chJour > Date.dernierJourDuMois(chMois, chAnnee)) {
            dateLendemain.chJour = 1;
            dateLendemain.chMois += 1;
            if (dateLendemain.chMois > 12) {
                dateLendemain.chMois = 1;
                dateLendemain.chAnnee +=  1;
            }
        }
        return dateLendemain;
    }

    /**
     *
     * @return
     */
    public Date dateDeLaVeille() {
        Date dateVeille = new Date(chJour-1, chMois, chAnnee);
        if (dateVeille.chJour < 1) {
            dateVeille.chMois -= 1;
            if (dateVeille.chMois < 1) {
                dateVeille.chMois = 12;
                dateVeille.chAnnee -= 1;
            }
            dateVeille.chJour = Date.dernierJourDuMois(dateVeille.chMois, dateVeille.chAnnee);
        }
        return dateVeille;
    }
    public int compareTo(Date parDate) {
        if (this.chAnnee == parDate.chAnnee) {
            if (this.chMois == parDate.chMois) {
                return this.chJour - parDate.chJour;
            }
            return this.chMois - parDate.chMois;
        }
        return this.chAnnee - parDate.chAnnee;
    }

}