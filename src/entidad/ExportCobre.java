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
    devolverá: luisx_saaxr@exportcobre.cl  */
    public String correo(){
        return "en construcción";
    }

    //b.	mesMayorExportación: devolverá el número del mes que hubo mayor exportación.
    public int mesMayorExportacion(){
        return 0;
    }

    /*c.	totalOtoñoInvierno: devolverá el total de exportaciones realizada en el
    periodo Otoño-Invierno (considerar los meses de abril a septiembre).*/
    public int totalOtonnoInvierno(){
        int suma = 0;
        for (int i=3;i<9;i++){
            suma = suma + toneladasExportadas[i];
        }
        return suma;
    }

    /*d.	cantidadExportada: devolverá la cantidad que se exportó en un mes X. 	*/
    public int cantidadExportada(int mesX){ //12
        return toneladasExportadas[mesX-1];
        //toneladasExportadas[12]
    }
}
