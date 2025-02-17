public class ClientPlanning {
    public static void main(String[] args) {
        Planning testPlanning = new Planning(5);
        testPlanning.ajout(new Reservation(new Date(28,01,2020),new PlageHoraire(new Horaire(15,15),new Horaire(16,30)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        testPlanning.ajout(new Reservation(new Date(28,01,2020),new PlageHoraire(new Horaire(15,15),new Horaire(16,15)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        testPlanning.ajout(new Reservation(new Date(28,01,2020),new PlageHoraire(new Horaire(15,15),new Horaire(16,15)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        testPlanning.ajout(new Reservation(new Date(29,01,2020),new PlageHoraire(new Horaire(15,15),new Horaire(16,15)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        testPlanning.ajout(new Reservation(new Date(30,01,2020),new PlageHoraire(new Horaire(15,15),new Horaire(16,15)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        testPlanning.ajout(new Reservation(new Date(29,02,2000),new PlageHoraire(new Horaire(14,45),new Horaire(16,15)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        testPlanning.ajout(new Reservation(new Date(29,02,2000),new PlageHoraire(new Horaire(16,15),new Horaire(17,30)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        testPlanning.ajout(new Reservation(new Date(27,02,2000),new PlageHoraire(new Horaire(16,15),new Horaire(17,30)),new String("Among Us")));
        System.out.println(testPlanning.toString());
        System.out.println(testPlanning.getReservation(new Date(29,02,2000)).toString());
        System.out.println(testPlanning.getReservations(new Date(29,02,2000))[0].toString());
        System.out.println(testPlanning.getReservations(new Date(29,02,2000))[1].toString());
    }

}
