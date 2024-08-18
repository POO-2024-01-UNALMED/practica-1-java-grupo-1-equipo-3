/**
 * Este módulo pertenece al paquete 'uiMain' y contiene la clase 'EvaluacionOperacion'.
 * 
 * Proporciona la funcionalidad para evaluar las operaciones de la empresa.
 * 
 * Permite ingresar fechas específicas o analizar toda la información disponible,
 * y proporciona análisis de ganancias, promedio diario, porcentajes de aumento y elementos más usados.
 * 
 * AUTORES: - Sebastian Estrada Villa
 *          - Valentina Luján Robledo
 *          - Santiago Ochoa Quintero
 */

package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.empresa.Factura;
import gestorAplicacion.externo.Parejas;


/**
  * La clase 'EvaluacionOperacion' gestiona la evaluación de las operaciones de la empresa.
  * 
  * Proporciona métodos para ingresar fechas, analizar datos y mostrar información estadística.
  */

public class EvaluacionOperacion {
    

    /**
      * Método principal para gestionar la evaluación de las operaciones.
      * 
      * Permite al usuario ingresar fechas y realizar análisis de datos.
      */

    public static void evaluacionOperacion(){

        int[] fechas = ingresarFechas();
        analisis(fechas[0], fechas[1]);

    }


    /**
      * Permite al usuario ingresar fechas específicas o analizar toda la información disponible.
      * 
      * @return Un arreglo de enteros que contiene la fecha de inicio y la fecha final.
      */

    public static int[] ingresarFechas(){
        @SuppressWarnings({ "resource", "unused" })
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



    /**
      * Realiza el análisis de los datos entre las fechas proporcionadas.
      * 
      * @param fecha1 Fecha de inicio del análisis
      * 
      * @param fecha2 Fecha final del análisis
      */

    public static void analisis(int fecha1, int fecha2){

        if(fecha1 == -1 && fecha2 == -1){

            return;
        }

        int fechaMin = Factura.getFechaMin();
        int fechaMax = Factura.getFechaMax();

        String opciones[] = new String[]{"Ganancias por dia", "Ganancias Totales", 
                "Promedio por dia", "Porcentaje de aumento", "Mas usados", "Cambiar fechas"};

        String opcion = new MenuAuxiliar("Ingrese información a obtener", opciones, "Volver al inicio").mostrarReturnString();

        ArrayList<Parejas<Integer, Double>> gananciasPorDia = Factura.gananciasPorDia(fecha1, fecha2);
        

        while(opcion!= "Volver al inicio"){

            switch(opcion){

                case "GANANCIAS POR DIA":
    
                        desplegarInfo(gananciasPorDia, "GANANCIA", "");
    
                    break;
    

                case "GANANCIAS TOTALES":
    
                        System.out.println("\nLas ganancias totales entre las fechas ingresadas han sido: " + Factura.ganancias(gananciasPorDia));
    
                    break;
    

                case "PROMEDIO POR DIA":
    
                        System.out.println("\nEl promedio por día es: " + Factura.promedioPorDia(gananciasPorDia));
    
                    break;
    

                case "PORCENTAJE DE AUMENTO":
    
                        desplegarInfo(Factura.porcentajeDeAumento(gananciasPorDia), "AUMENTO", "%");
    
                    break;
    

                case "CAMBIAR FECHAS":
    
                    System.out.println("\nLa fecha mínima es " + fechaMin + " y la fecha máxima es " + fechaMax);

                    System.out.println("Ingrese fecha de inicio: ");
                    fecha1 = MenuAuxiliar.ingresarConLimites(fechaMin, fechaMax);

                    System.out.println("Ingrese fecha final: ");
                    fecha2 = MenuAuxiliar.ingresarConLimites(fecha1, fechaMax);

                    gananciasPorDia =  Factura.gananciasPorDia(fecha1, fecha2);
    
                    break;


                case "MAS USADOS":

                    masUsados(fecha1, fecha2);

                    break;


                case "VOLVER AL INICIO":

                        return;
    

                default:

                    System.out.println("Ha ingresado un valor no válido. Por favor vuelva a intentarlo");
    
                
            }

            opcion = new MenuAuxiliar("Ingrese información a obtener", opciones, "Volver al inicio").mostrarReturnString();
        }
    }



    /**
      * Muestra los elementos más usados entre las fechas proporcionadas.
      * 
      * @param fecha1 Fecha de inicio del análisis
      * 
      * @param fecha2 Fecha final del análisis
      */

    public static void masUsados(int fecha1, int fecha2){

        String opciones[] = new String[]{"Tienda más usada", "Transporte más usado", "Cliente al que más se le ha vendido"};

        int opcion = new MenuAuxiliar("Seleccione moda: ", opciones).mostrar();

        System.out.println("\n");

        while(opcion != 0){

            // Manejo de opciones
            switch(opcion){

                case 1:

                    // Uso de ligadura dinamica
                    System.out.println("La tienda más usada ha sido "  + Factura.moda(fecha1, fecha2, "tienda").getNombre());

                    break;


                case 2:     

                    // Uso de ligadura dinamica
                    System.out.println("El transporte más usado ha sido " + Factura.moda(fecha1, fecha2, "transporte").getNombre());

                    break;


                case 3:

                    // Uso de ligadura dinamica
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



    /**
      * Despliega la información proporcionada en el formato adecuado.
      * 
      * @param info Lista de pares de información a desplegar
      * 
      * @param strData Etiqueta de los datos
      * 
      * @param posfijo Posfijo a añadir a los valores
      */
    
    public static void desplegarInfo(ArrayList<Parejas<Integer, Double>> info, String strData, String posfijo){

        System.out.println("DIA \t " + strData);
    
        for(Parejas<Integer, Double> par : info){
            
            System.out.println(par.getKey() + "\t" + par.getValue() + posfijo);
        }
    }
}
