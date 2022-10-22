public class ConversorDeTemperaturas {

    public static void main(String[] args) {

        int quantidadeTemp = Services.leiaIntMsg("Entre com a quantidade de temperaturas: ");
        double[] arrTempOrigem = Services.leiaDoubleArray(quantidadeTemp);
        double[] arrTempTrans = new double[arrTempOrigem.length];

        System.out.println("Selecione uma unidade de origem:");
        String unidadeOrig = Services.selecionaUnidade();


        System.out.println("Selecione a unidade transformada:");
        String unidadeTrans = Services.selecionaUnidade();


        //Calcula novo array com temperaturas convertidas
        for (int i = 0; i < arrTempOrigem.length; i++) {
            switch (unidadeOrig) {
                case "Celsius":
                    if (unidadeTrans.equals("Fahrenheit")) {
                        arrTempTrans[i] = Services.convCelsiusParaFahrenheit(arrTempOrigem[i]);
                    } else if (unidadeTrans.equals("Kelvin")) {
                        arrTempTrans[i] = Services.convCelsiusParaKelvin(arrTempOrigem[i]);
                    } else if (unidadeTrans.equals("Celsius")) {
                        arrTempTrans[i] = arrTempOrigem[i];
                    }
                case "Fahrenheit":
                    if (unidadeTrans.equals("Fahrenheit")) {
                        arrTempTrans[i] = arrTempOrigem[i];
                    } else if (unidadeTrans.equals("Kelvin")) {
                        arrTempTrans[i] = Services.convFahrenheitParaKelvin(arrTempOrigem[i]);
                    } else if (unidadeTrans.equals("Celsius")) {
                        arrTempTrans[i] = Services.convFahrenheitParaCelsius(arrTempOrigem[i]);
                    }

                case "Kelvin":
                    if (unidadeTrans.equals("Fahrenheit")) {
                        arrTempTrans[i] = Services.convKelvinParaFahrenheit(arrTempOrigem[i]);
                    } else if (unidadeTrans.equals("2")) {
                        arrTempTrans[i] = arrTempOrigem[i];
                    } else if (unidadeTrans.equals("1")) {
                        arrTempTrans[i] = Services.convKelvinParaCelsius(arrTempOrigem[i]);
                    }
            }
        }

        Services.imprimeConversao(arrTempOrigem, unidadeOrig, arrTempTrans, unidadeTrans);

        System.out.printf("A média das temperaturas originais é %.2f graus %s", Services.calculaMediaArray(arrTempOrigem), unidadeOrig);
        System.out.printf("A média das temperaturas convertidas é %.2f graus %s", Services.calculaMediaArray(arrTempTrans), unidadeTrans);

    }
}