package uiMain;

import java.util.HashMap;
import java.util.Scanner;

import gestorAplicacion.empresa.Factura;

public class EvaluacionOperacion {
    
    public static void evaluacionOperacion(){

        int[] fechas = ingresarFechas();
        analisis(fechas[0], fechas[1]);

    }

    public static int[] ingresarFechas(){

        Scanner sc = new Scanner(System.in);
        int opcion = new MenuAuxiliar("REPORTE", new String[]{"Analizar toda la información", 
                                                    "Ingresar fechas específicas"}).mostrar();
       
        int fechaMin = Factura.getFechaMin();
        int fechaMax = Factura.getFechaMax();

        while(opcion != 0){

        // Manejo de opciones
        switch(opcion){

            case 1:

                return new int[]{fechaMin, fechaMax};


            case 2:

                System.out.println("\nLa fecha mínima es " + fechaMin + " y la fecha máxima es " + fechaMax);

                System.out.println("Ingrese fecha de inicio: ");
                int fecha1 = MenuAuxiliar.ingresarConLimites(fechaMin, fechaMax);

                System.out.println("Ingrese fecha final: ");
                int fecha2 = MenuAuxiliar.ingresarConLimites(fecha1, fechaMax);
                
                return new int[]{fecha1, fecha2};


            case 0:

                return new int[]{-1, -1}; 

            default:

            System.out.println("Ha ingresado un valor no válido. Por favor vuelva a intentarlo");

                break;

        }

        opcion = new MenuAuxiliar("REPORTE", new String[]{"Analizar toda la información", 
                                                    "Ingresar fechas específicas"}).mostrar();
    }

    return new int[]{-1, -1}; 

}

    public static void analisis(int fecha1, int fecha2){

        if(fecha1 == -1 && fecha2 == -1){

            return;
        }

        int fechaMin = Factura.getFechaMin();
        int fechaMax = Factura.getFechaMax();

        String opciones[] = new String[]{"Ganancias por dia", "Ganancias Totales", 
                "Promedio por dia", "Porcentaje de aumento", "Modas estadisticas", "Cambiar fechas"};

        String opcion = new MenuAuxiliar("Ingrese información a obtener", opciones, "Volver al inicio").mostrarReturnString();

        HashMap<Integer, Double> disc =  Factura.gananciasPorDia(fecha1, fecha2);
        
        while(opcion!= "Volver al inicio"){

            switch(opcion){

                case "GANANCIAS POR DIA":
    
                        desplegarInfo(disc, "GANANCIA", "");
    
                    break;
    

                case "GANANCIAS TOTALES":
    
                        System.out.println("\nLas ganancias totales entre las fechas ingresadas han sido: " + Factura.ganancias(disc));
    
                    break;
    

                case "PROMEDIO POR DIA":
    
                        System.out.println("\nEl promedio por día es: " + Factura.promedioPorDia(disc));
    
                    break;
    

                case "PORCENTAJE DE AUMENTO":
    
                        desplegarInfo(Factura.porcentajeDeAumento(disc), "AUMENTO", "%");
    
                    break;
    

                case "CAMBIAR FECHAS":
    
                    System.out.println("\nLa fecha mínima es " + fechaMin + " y la fecha máxima es " + fechaMax);

                    System.out.println("Ingrese fecha de inicio: ");
                    fecha1 = MenuAuxiliar.ingresarConLimites(fechaMin, fechaMax);

                    System.out.println("Ingrese fecha final: ");
                    fecha2 = MenuAuxiliar.ingresarConLimites(fecha1, fechaMax);

                    disc =  Factura.gananciasPorDia(fecha1, fecha2);
    
                    break;


                case "MODAS ESTADISTICAS":

                        modas(fecha1, fecha2);

                    break;


                case "VOLVER AL INICIO":

                        return;
    

                default:

                    System.out.println("Ha ingresado un valor no válido. Por favor vuelva a intentarlo");
    
                
            }

            opcion = new MenuAuxiliar("Ingrese información a obtener", opciones, "Volver al inicio").mostrarReturnString();
        }
    }

    public static void modas(int fecha1, int fecha2){

        String opciones[] = new String[]{"Tienda más usada", "Transporte más usado", "Cliente al que más se le ha vendido"};

        int opcion = new MenuAuxiliar("Seleccione moda: ", opciones).mostrar();

        System.out.println("\n");

        while(opcion != 0){

            // Manejo de opciones
            switch(opcion){

                case 1:

                    System.out.println("La tienda más usada ha sido "  + Factura.moda(fecha1, fecha2, "tienda").getNombre());

                    break;


                case 2:     

                    System.out.println("El transporte más usado ha sido " + Factura.moda(fecha1, fecha2, "transporte").getNombre());

                    break;


                case 3:

                    System.out.println("El cliente al que más se le ha vendido ha sido " + Factura.moda(fecha1, fecha2, "cliente").getNombre());

                    break;


                case 0:

                    return;


                default:

                    System.out.println("Ha ingresado un valor no válido. Por favor vuelva a intentarlo");

                break;
            }

            System.out.println("\n");

             opcion = new MenuAuxiliar("Seleccione moda: ", opciones).mostrar();
        }
    }

    public static void desplegarInfo(HashMap <Integer, Double> info, String strData, String posfijo){

        System.out.println("DIA \t " + strData);
    
        for(int i: info.keySet()){
            
            System.out.println(i + "\t" + info.get(i) + posfijo);
        }
    
    
    }
}
