package co.edu.uniquindio.agenda.model;

import java.util.Arrays;

public class Utilidades {

    public static int buscarNumMasRepetido(int[] array) {

        //El m�todo requiere de que los n�meros est�n ordenados.
        //Lo que nos importa realmente es que los n�meros iguales est�n todos juntos.
        Arrays.sort(array);

        //Nota, cuando me refiero a tramo de n�meros, todos el conjunto de n�meros iguales. Esto es, verbigracia:
        //conjuntoA = {1,1,2,2,2,3,3,3,4,4,4,4} Aqu� existen 4 tramos de n�meros dados por los n�meros 1,2,3 y 4.

        int num = array[0]; //N�mero que retornaremos
        int cOld = 0;       //Contador que guarda el n�mero de repeticiones del n�mero m�s repetido. Va cambiando seg�n se corra el c�digo.
        int cNew;            //Contador de repeticiones de los nuevos tramos de n�meros.
        int repCounter = 1; //Contador de repeticiones.


        for (int i = 0; i <= array.length - 2; i++) {

            if (array[i] == array[i + 1])
                repCounter++;

            if (array[i] != array[i + 1]) {
                cNew = repCounter;
                repCounter = 1;

                if (cNew>cOld) {
                    num = array[i];

                    cOld = cNew;
                    cNew =0;
                }
            }

            //Si no se pone este if, entonces nunca se va a evaluar el �ltimo tramo de n�meros.
            if (i == array.length-2){
                if (repCounter>cOld)
                    num= array[array.length-1];
            }
        }


        return num;
    }
}