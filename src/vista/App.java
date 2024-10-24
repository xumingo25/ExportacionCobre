package vista;

import entidad.ExportCobre;

public class App {
    public static void main(String[] args) {
            ExportCobre exportCobre = null;

            int opcion;

            do{
                opcion = menu();

                switch (opcion){
                    case 1:
                        //Ingresar exportación
                        exportCobre = crearExportacion();
                        mostrarInfoExportacion(exportCobre);
                        break;
                    case 2:
                        //correo
                        if(exportCobre==null){
                            System.out.println("Favor registre exportación");
                        }else{
                            System.out.println("Mail de cliente: "+exportCobre.correo());
                        }
                        break;
                    case 3:
                        //mes mayor exportación y cantidad
                        if(exportCobre==null){
                            System.out.println("Favor registre exportación");
                        }else{
                            int mes = exportCobre.mesMayorExportacion();
                            System.out.println("mes mayor exportación: "+ mes
                                    +" y cantidad: "+exportCobre.cantidadExportada((mes)));
                        }
                        break;
                    case 4:
                        //Total otoño invierno

                        if(exportCobre==null){
                            System.out.println("Favor registre exportación");
                        }else{
                            System.out.println("Total otoño invierno: "+exportCobre.totalOtonnoInvierno());
                        }
                        break;
                    case 5:
                        //Cantidad exportada en junio
                        if(exportCobre==null){
                            System.out.println("Favor registre exportación");
                        }else{
                            System.out.println("Cantidad exportada en junio: "+exportCobre.cantidadExportada(6));
                        }
                        break;
                }


            }while(opcion!=6);
    }

    public static int menu(){
        System.out.println("---Sistema de exportación de cobre---");
        System.out.println("-------------------------------------");
        System.out.println("1.\tIngresar exportación");
        System.out.println("2.\tCorreo");
        System.out.println("3.\tMes con mayor exportación y su cantidad");
        System.out.println("4.\tTotal, exportado en otoño-invierno");
        System.out.println("5.\tCantidad exportada en el mes de junio  ");
        System.out.println("6.\tSalir");
        System.out.println("-------------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");
        return Leer.datoInt();
    }

    public static ExportCobre crearExportacion(){
        System.out.println("favor ingrese nro de exportación");
        int nroExportacion = Leer.datoInt();
        String paisDestino;
        do{
            System.out.println("favor ingrese pais de destino (ej: Chile/Argertina/Peru etc)");
             paisDestino = Leer.dato(); //ARG
        }while(paisDestino.length()<4); //TRUE SE REPITE

        String nombreCliente;
        String[] aux = null;

        do{
            System.out.println("Favor ingrese el nombre del cliente (Nombre Apellido Apellido ej: Luis Saa Cancino)");
            nombreCliente = Leer.dato(); //Domingo ALfredo Saavedra Saavedra
            aux = nombreCliente.split(" ");
        }while(aux.length !=3); //true


        return new ExportCobre(nroExportacion,paisDestino,nombreCliente);
    }

    public static void mostrarInfoExportacion(ExportCobre exportCobre){
        System.out.println("Datos de exportación");

        System.out.println("Nombre cliente: "+ exportCobre.getNombreCliente());
        System.out.println("Nro Exportación: "+exportCobre.getNroExportacion());
        System.out.println("Pais Destino: "+exportCobre.getPaisDestino());

        for(int i=0; i<exportCobre.getToneladasExportadas().length;i++){
            System.out.println("Toneladas exportadas mes "+ (i+1) + ", total: "+
                    exportCobre.getToneladasExportadas()[i]);
        }
    }
}
