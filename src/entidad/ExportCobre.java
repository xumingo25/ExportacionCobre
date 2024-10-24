package entidad;

public class ExportCobre {
    //ATRIBUTOS
    private int nroExportacion;
    private String paisDestino;
    private String nombreCliente;
    private int[] toneladasExportadas;

    public ExportCobre(int nroExportacion, String paisDestino, String nombreCliente) {
        this.nroExportacion = nroExportacion;
        this.paisDestino = paisDestino;
        this.nombreCliente = nombreCliente;
        this.toneladasExportadas = new int[12];


        for (int i=0;i<toneladasExportadas.length;i++){
            //(int) (Math.random()*(5-0)+1) ;//random entre 1 a 5
            toneladasExportadas[i] = (int) (Math.random()*(1501-0)) ;//random entre 0 a 1500
        }

    }

    public ExportCobre(){

    }

    public int getNroExportacion() {
        return nroExportacion;
    }

    public void setNroExportacion(int nroExportacion) {
        this.nroExportacion = nroExportacion;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int[] getToneladasExportadas() {
        return toneladasExportadas;
    }

    public void setToneladasExportadas(int[] toneladasExportadas) {
        this.toneladasExportadas = toneladasExportadas;
    }

    /*
    * a.	correo: Devolverá el correo del cliente. El correo estará compuesto
    * por las 5 primeras letras del nombre, un guion bajo, las cuatro últimas letras
    * del apellido paterno, la segunda letra del país destino, más @exportcobre.cl
    * (todo en minúscula). Si el nombre o el apellido tiene menos letras de las que
    *   se necesitan, se les asignará a las letras faltantes el carácter x.
    Ejemplo: Si el cliente es Luis Saa Cancino y país destino Grecia
    * domingo saavedra saavedra chile
    * domin_edrah@exportcobre.cl
    devolverá: luisx_saaxr@exportcobre.cl  */
    public String correo(){ //Luis Saa Cancino
                            // 0    1     2
        String email = "";


        String[] nombreCompleto = nombreCliente.split(" ");

        //extraer 5 primeros caracteres del nombre
        if(nombreCompleto[0].length()>=5){
            //tiene 5 o mas caracteres
            email = nombreCompleto[0].substring(0,5);
        }else{
            //tiene 4 o menos
            //¿Cuantos menos tiene? lee 3 = 2 leexx
            email = nombreCompleto[0];
            int dif = 5 - nombreCompleto[0].length();

            for(int i= 1; i<=dif;i++){
                email =email.concat("x");
            }
        }

        email = email.concat("_");

        //extraer 4 caracteres del apellido paterno
        //saavedra
        //tiene 4 o mas caracteres el apellido
        if(nombreCompleto[1].length()>=4){
            //si tiene 4 caracteres o mas
            email = email + nombreCompleto[1].substring(nombreCompleto[1].length()-4);
        }else{
            email = email+nombreCompleto[1];
            int diff = 4 - nombreCompleto[1].length(); //saa
            for(int i= 1; i<=diff;i++){
                email =email.concat("x");
            }
        }

        email = email + paisDestino.substring(1,2) + "@exportcobre.cl";

        return email.toLowerCase();
    }

    //b.	mesMayorExportación: devolverá el número del mes que hubo mayor exportación.
    public int mesMayorExportacion(){
        int max=-1, mes=0;
        for(int i=0;i<toneladasExportadas.length;i++){
            if(toneladasExportadas[i]>max){
                max = toneladasExportadas[i];
                mes = (i+1);
            }
        }
        return mes;

    }

    /*c.	totalOtoñoInvierno: devolverá el total de exportaciones realizada en el
    periodo Otoño-Invierno (considerar los meses de abril a septiembre).*/
    public int totalOtonnoInvierno(){
        int suma = 0;
        for (int i=3;i<9;i++){
            suma = suma + this.toneladasExportadas[i];
        }
        return suma;
    }

    /*d.	cantidadExportada: devolverá la cantidad que se exportó en un mes X. 	*/
    public int cantidadExportada(int mesX){ //12
        return this.toneladasExportadas[mesX-1];
        //toneladasExportadas[12]x
    }
}
