import lists.DynamicList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class EjArchivos {
    /**
     * Se desea realizar un estudio comparativo entre distintos modelos de
     * automotores de 10 marcas diferentes que están numeradas del 1 al 10.
     * Para ello se recibe un archivo RandomAccesFile en el cual cada registro
     * contiene el número de marca, la cantidad de km recorridos y el tiempo en
     * minutos que tardó.
     *
     * Ejemplo de archivo:
     * 2;205;124
     * 7;400;360
     * 2;560;580
     *
     * Observar que pueden venir varios autos de la misma marca.
     *
     * Hacer una aplicación
     *
     * a) que informe la velocidad promedio de cada marca.
     *
     * b) que genere un archivo RandomAccessFile donde cada registro
     * contenga la marca y la cantidad de autos evaluados.
     *
     * */


    public void generateDataFile() throws IOException {
        File file = new File("datos.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(0);
        for (int i = 0; i < 100; i++) {
            raf.writeInt(randomNumberInRange(1,11));
            raf.writeInt(randomNumberInRange(200, 600));
            raf.writeInt(randomNumberInRange(170, 700));
        }
        raf.close();

    }
    public static int randomNumberInRange(int start, int end){
        Random r = new Random();
        int low = start;
        int high = end;
        return r.nextInt(high-low) + low;
    }

    public void generateCounterFile() throws IOException {
        File file = new File("resultados.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        Car[] cars = readCarsFile();
        for (int i = 0; i < 10; i++) {
            int marca = (i+1);
            int autosTotales = 0;
            for (int j = 0; j < cars.length; j++) {
                if(cars[j].getMarca() == marca) autosTotales++;
            }
            raf.writeInt(marca);
            raf.writeInt(autosTotales);
        }
        raf.close();
    }


    public void showMeanSpeedPerBrand() throws IOException {
        Car[] cars = readCarsFile();
        DynamicList<Float>[] marcasConVelocidades = new DynamicList[10];
        for (int i = 0; i < cars.length; i++) {
            int carBrand = cars[i].getMarca();
            int carKms = cars[i].getKms();
            int carTime = cars[i].getMinutes();

            float meanSpeed = (float) (carKms/carTime);

            marcasConVelocidades[carBrand-1].insertNext(meanSpeed);
        }
        for (int i = 0; i < marcasConVelocidades.length; i++) {
            System.out.println("Marca nro. "+(i+1) + " - Velocidad Promedio: " + calcularVelocidad(marcasConVelocidades[i]));
        }


    }

    private Float calcularVelocidad(DynamicList<Float> marcasConVelocidade) {
        float promedio = 0;
        for (int i = 0; i < marcasConVelocidade.size(); i++) {
            marcasConVelocidade.goTo(i);
            promedio += marcasConVelocidade.getActual();
        }
        return promedio/marcasConVelocidade.size();
    }


    private Car[] readCarsFile() throws IOException {
        File file = new File("datos.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int registryLength = 4+4+4; //3 ints
        int regCant = (int) (raf.length()/registryLength);
        Car[] cars = new Car[regCant];
        raf.seek(0);
        for (int i = 0; i < regCant; i++) {
            cars[i] = new Car(raf.readInt(),raf.readInt(),raf.readInt());
        }
        raf.close();
        return cars;
    }


}
