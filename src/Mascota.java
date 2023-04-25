import java.util.Arrays;

public class Mascota {
    private String nombre;
    private int energia;
    private int humor;
    private int contIngesta;
    private int contActividad;
    private boolean vivo;
    private boolean dormido;
    private String motivoMuerte;
    private String motivoInaccion;
    private String[]HUMORES={"muy enojado", "enojado", "neutral", "contento", "chocho"};

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.energia = 75;
        this.humor = 3;
        this.vivo = true;
        this.dormido = false;
        this.contActividad = 0;
        this.contIngesta = 0;
        this.motivoInaccion="";
        this.motivoMuerte = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setEnergia(int energia) {
        if (energia>100){
            this.energia = 100;
        } else if (energia<0) {
            this.energia = 0;
            this.vivo = false;
            this.motivoMuerte="Cansancio";
        } else {
            this.energia = energia;
        }
    }

    public void setHumor(int humor) {
        if (humor>5){
            this.humor = 5;
        } else if (humor<=0) {
            this.humor = 1;
            this.dormido=true;
            this.motivoInaccion="Mal Humor";
        } else {
            this.humor = humor;
        }
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean isDormido() {
        return dormido;
    }

    public void setDormido(boolean dormido) {
        this.dormido = dormido;
    }

    public String getMotivoMuerte() {
        return motivoMuerte;
    }

    public void setMotivoMuerte(String motivoMuerte) {
        this.motivoMuerte = motivoMuerte;
    }

    public String getMotivoInaccion() {
        return motivoInaccion;
    }

    public void setMotivoInaccion(String motivoInaccion) {
        this.motivoInaccion = motivoInaccion;
    }

    public boolean comer(){
        boolean hecho;
        if (isDormido() || !isVivo()){
            hecho=false;
        } else {
            if (this.contIngesta<3) {
                setEnergia((int) (this.energia * 1.10));
                setHumor(this.humor+=1);
            } else {
                setEnergia((int) (this.energia * 1.10));
                setHumor(this.humor-=1);
            }
            if (this.contIngesta>=5){
                setVivo(false);
                this.energia=0;
                this.humor=0;
                setMotivoMuerte("Empacho");
            }
            this.contIngesta++;
            this.contActividad=0;
            hecho = true;
        }
        return hecho;
    }

    public boolean beber(){
        boolean hecho;
        if (isDormido() || !isVivo()){
            hecho = false;
        } else {
            if (this.contIngesta<3) {
                setEnergia((int) (this.energia * 1.05));
                setHumor(this.humor+=1);
            } else {
                setEnergia((int) (this.energia * 1.05));
                setHumor(this.humor-=1);
            }
            if (this.contIngesta>=5){
                setVivo(false);
                this.energia=0;
                this.humor=0;
                setMotivoMuerte("Empacho");
            }
            this.contIngesta++;
            this.contActividad=0;
            hecho=true;
        }
        return hecho;
    }

    public boolean correr(){
        boolean hecho;
        if (isDormido() || !isVivo()){
            hecho = false;
        } else {
            if (this.contActividad<3) {
                setEnergia(this.energia - (int) (this.energia * 0.35));
                setHumor(this.humor -= 2);
            } else {
                setDormido(true);
                setMotivoInaccion("Empacado");
            }
            this.contActividad++;
            this.contIngesta=0;
            hecho = true;
        }
        return hecho;
    }

    public boolean saltar(){
        boolean hecho;
        if (isDormido() || !isVivo()){
            hecho = false;
        } else {
            if (this.contActividad<3) {
                setEnergia(this.energia - (int) (this.energia * 0.15));
                setHumor(this.humor -= 2);
            } else {
                setDormido(true);
                setMotivoInaccion("Empacado");
            }
            this.contActividad++;
            this.contIngesta=0;
            hecho = true;
        }
        return hecho;
    }

    public boolean dormir(){
        boolean hecho;
        if (isDormido() || !isVivo()){
            hecho = false;
        } else {
            setDormido(true);
            setMotivoInaccion("Dormido");
            setEnergia(this.energia+25);
            setHumor(this.humor+=2);
            this.contActividad=0;
            this.contIngesta=0;
            hecho = true;
        }
        return hecho;
    }

    public boolean despertar(){
        boolean hecho;
        if (!isDormido() || !isVivo()){
            hecho = false;
        } else {
            setDormido(false);
            setMotivoInaccion("");
            setHumor(this.humor--);
            hecho = true;
        }
        return hecho;
    }

    @Override
    public String toString() {
        String estado;
        if (isDormido()){
            estado= "Mascota: "+nombre + '\n' +
                    "Energía: " + energia +
                    "\nHumor: " + HUMORES[humor-1] +
                    "\nVive: Sí" +
                    "\nDuerme: Sí" +
                    "\nMotivo de Inacción: " + motivoInaccion ;
        } else if (!isVivo()) {
            estado= "Mascota: "+nombre + '\n' +
                    "\nVive: No" +
                    "\nMotivo de la Muerte: " + motivoMuerte;
        } else {
            estado = "Mascota: "+nombre + '\n' +
                    "Energía: " + energia +
                    "\nHumor: " + HUMORES[humor-1] +
                    "\nVive: Sí" +
                    "\nDuerme: No";
        }
        return estado;
    }
}
