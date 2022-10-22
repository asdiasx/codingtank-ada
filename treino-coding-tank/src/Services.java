import java.sql.SQLOutput;
import java.util.Scanner;

public class Services {

    public static String leiaStringMsg(String msg) {
        Scanner entrada = new Scanner(System.in);
        if (msg != null) {
            System.out.println(msg);
        }
        return entrada.nextLine();
    }

    public static double leiaDoubleMsg(String msg) {
        Scanner entrada = new Scanner(System.in);
        if (msg != null) {
            System.out.println(msg);
        }
        return entrada.nextDouble();
    }

    public static int leiaIntMsg(String msg) {
        Scanner entrada = new Scanner(System.in);
        if (msg != null) {
            System.out.println(msg);
        }
        return entrada.nextInt();
    }

    public static double[] leiaDoubleArray(int tamanho) {
        double[] arrDoubles = new double[tamanho];

        for (int i = 0; i < arrDoubles.length; i++) {
            String msg = String.format("Entre com a temperatura %d de %d", i + 1, tamanho);
            arrDoubles[i] = leiaDoubleMsg(msg);
        }

        return arrDoubles;
    }

    public static void imprimeConversao(double[] arrOrig, String unidOr, double[] arrTrans, String unidTrans) {
        for (int i = 0; i < arrOrig.length; i++) {
            System.out.printf("Temperatura %.2f graus em %s corresponde a %.2f graus %s.\n", arrOrig[i], unidOr, arrTrans[i], unidTrans);
        }
        System.out.println("");
    }

    public static double calculaMediaArray(double[] array) {
        double acumulador = 0;
        for (int i = 0; i < array.length; i++) {
            acumulador += array[i];
        }
        return acumulador / array.length;
    }

    public static double convCelsiusParaFahrenheit(double celsius) {
        double fahrenheit = celsius * (9d / 5) + 32;
        return fahrenheit;
    }

    public static double convFahrenheitParaCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * (5d / 9);
        return celsius;
    }

    // fonte da formula: https://byjus.com/chemistry/celsius-to-kelvin/
    public static double convCelsiusParaKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        return kelvin;
    }

    // fonte da formula: https://byjus.com/chemistry/celsius-to-kelvin/
    public static double convKelvinParaCelsius(double kelvin) {
        double celsius = kelvin - 273.15;
        return celsius;
    }

    public static double convKelvinParaFahrenheit(double kelvin) {
        double fahrenheit = convCelsiusParaFahrenheit(convKelvinParaCelsius(kelvin));
        return fahrenheit;
    }

    public static double convFahrenheitParaKelvin(double fahrenheit) {
        double kelvin = convCelsiusParaKelvin(convFahrenheitParaCelsius(fahrenheit));
        return kelvin;
    }


    public static String selecionaUnidade() {
        System.out.println("Digite 1, 2 ou 3:");
        System.out.println("1- Celsius");
        System.out.println("2- Kelvin");
        System.out.println("3- Fahrenheit");

        StringBuilder sbReturn = new StringBuilder();

        boolean fazLoop = true;

        while (fazLoop) {

            String itemEscolhido = leiaStringMsg("");

            if ("1".equals(itemEscolhido)) {
                sbReturn.append("Celsius");
                fazLoop = false;

            } else if ("2".equals(itemEscolhido)) {
                sbReturn.append("Kelvin");
                fazLoop = false;

//                return unidadeEscolhida;
            } else if ("3".equals(itemEscolhido)) {
                sbReturn.append("Fahrenheit");
                fazLoop = false;
//                return unidadeEscolhida;
            } else {
                System.out.println("Voce digitou um valor inválido, deve digitar 1, 2 ou 3");
            }

        }
        return sbReturn.toString();
    }



}
