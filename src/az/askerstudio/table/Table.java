/*
_________________________________________
|                                       |
|   Copyright by Asker Takhmazov 2021   |
|          Salam Aleykum                |
|_______________________________________|
 */
package az.askerstudio.table;

import java.util.Arrays;

public class Table {
    private final String[][] array;

    public Table(Parameters parameters) {
        array = new String[parameters.getArray().length + 1][6];
        headerInit();
        bodyInit(parameters.getArray());
    }

    private void headerInit() {
        array[0][0] = "НОМЕР ПЛАТЕЖА";
        array[0][1] = "МЕСЯЦ / ГОД";
        array[0][2] = "ПЛАТЕЖ ПО ОСНОВНОМУ ДОЛГУ";
        array[0][3] = "ПЛАТЕЖ ПО ПРОЦЕНТАМ";
        array[0][4] = "ОСТАТОК ОСНОВНОГО ДОЛГА";
        array[0][5] = "ОБЩАЯ СУММА ПЛАТЕЖА";
    }

    private void bodyInit(String[][] array) {
        for (int i = 1; i < this.array.length; i++) {
            System.arraycopy(array[i - 1], 0, this.array[i], 0, 6);
        }
    }

    public String[][] getArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            string.append(Arrays.toString(array[i])).append('\n');
        }
        return string.toString();
    }
}
