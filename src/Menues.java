import java.util.Scanner;

public class Menues {
    private Mascota masc=null;

    public Menues() {
        int opc1, opc2;
        do {
            opc1=menuPrincipal();
            if (opc1==1){
                crearMascota();
                System.out.println();
                System.out.println(masc.toString());
                System.out.println();
            } else if (opc1==2) {
                boolean hecho = false;
                do {
                    opc2=jugar();
                    if (opc2==1){
                        hecho=masc.comer();
                    } else if (opc2==2) {
                        hecho=masc.beber();
                    } else if (opc2==3) {
                        hecho=masc.correr();
                    } else if (opc2==4) {
                        hecho=masc.saltar();
                    } else if (opc2==5) {
                        if (masc.isDormido()){
                            hecho=masc.despertar();
                        } else {
                            hecho=masc.dormir();
                        }
                    }
                    if (hecho) {
                        System.out.println();
                        System.out.println("Listo!");
                        System.out.println();
                        System.out.println(masc.toString());
                    } else {
                        System.out.println();
                        System.out.println(masc.getNombre()+" no pudo realizar la acción.");
                        if (masc.isDormido()){
                            System.out.println("Tu mascota se encuentra dormida por " + masc.getMotivoInaccion());
                        } else if (!masc.isVivo()) {
                            System.out.println("Tu mascota se murió por " + masc.getMotivoMuerte());
                        } else {
                            System.out.println("Error desconocido");
                        }
                    }
                    System.out.println();
                } while (opc2!=6);
            } else if (opc1 == 3) {
                eliminar();
            }
        }while (opc1!=4);
        System.out.println("                       __\n" +
                "                     .'  '.\n" +
                "                 _.-'/  |  \\\n" +
                "    ,        _.-\"  ,|  /  0 `-.\n" +
                "    |\\    .-\"       `--\"\"-.__.'=====================-,\n" +
                "    \\ '-'`        .___.--._)=========================|\n" +
                "     \\            .'      |                          |\n" +
                "      |     /,_.-'        |        Gracias           |\n" +
                "    _/   _.'(             |           por            |\n" +
                "   /  ,-' \\  \\            |        Jugar!!           |\n" +
                "   \\  \\    `-'            |                          |\n" +
                "    `-'                   '--------------------------'");
    }

    public int menuPrincipal(){
        int resp;
        Scanner scn = new Scanner(System.in);
        System.out.println("TAMAGOTCHI");
        System.out.println("─▌█──║─║╔═║─║─╔═╗─\n" +
                "─███─╠═╣╠═║─║─║─║─\n" +
                "─▐█▐─║─║╚═╚═╚═╚═╝─\n" +
                "─▐▐───────────────\n" +
                "─▐▐───────────────");
        System.out.println("****************");
        System.out.println("Elegí una opción");
        System.out.println("****************");
        System.out.println("1- Crear mascota");
        System.out.println("2- Jugar");
        System.out.println("3- Eliminar");
        System.out.println("4- Salir");
        System.out.println("****************");
        System.out.print("Ingresá el número de la opción elegida: ");
        resp = scn.nextInt();
        return resp;
    }
    public void crearMascota(){
        String nombre;
        Scanner scn = new Scanner(System.in);
        System.out.println("░░░░░░░▄██▄░░░░░░▄▄░░\n" +
                "░░░░░░░▐███▀░░░░░▄███▌\n" +
                "░░▄▀░░▄█▀▀░░░░░░░░▀██░\n" +
                "░█░░░██░░░░░░░░░░░░░░░\n" +
                "█▌░░▐██░░▄██▌░░▄▄▄░░░▄\n" +
                "██░░▐██▄░▀█▀░░░▀██░░▐▌\n" +
                "██▄░▐███▄▄░░▄▄▄░▀▀░▄██\n" +
                "▐███▄██████▄░▀░▄█████▌\n" +
                "▐████████████▀▀██████░\n" +
                "░▐████▀██████░░█████░░\n" +
                "░░░▀▀▀░░█████▌░████▀░░\n" +
                "░░░░░░░░░▀▀███░▀▀▀░░░░");
        System.out.println();
        System.out.println("Vamos  crear una mascota");
        System.out.print("Ingresá un nombre para tu mascota: ");
        nombre = scn.nextLine();
        masc = new Mascota(nombre);
        System.out.println("Mascota creada!");
    }
    public int jugar(){
        int resp=0;
        if(masc!=null) {
            Scanner scn = new Scanner(System.in);
            System.out.println("**************************");
            System.out.println();
            System.out.println("Qué hará tu mascota?");
            System.out.println("1- Comer");
            System.out.println("2- Beber");
            System.out.println("3- Correr");
            System.out.println("4- Saltar");
            if (masc.isDormido()) {
                System.out.println("5- Despertar");
            } else {
                System.out.println("5- Dormir");
            }
            System.out.println("6- Volver");
            System.out.println("**************************");
            System.out.print("Ingresá el número de la opción elegida: ");
            resp = scn.nextInt();
        } else {
            System.out.println("La mascota no existe. Debe crear una nueva para jugar");
            resp=6;
        }
        return resp;
    }
    public void eliminar(){
        if (masc!= null) {
            System.out.println("***********************");
            masc = null;
            System.out.println("Se eliminó la mascota. Debe crear una nueva para jugar");
        } else {
            System.out.println("***********************");
            System.out.println("No existe ninguna mascota para eliminar");
        }
    }
}
