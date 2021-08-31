/*
_________________________________________
|                                       |
|   Copyright by Asker Takhmazov 2021   |
|          Salam Aleykum                |
|_______________________________________|
 */
package az.askerstudio;

import az.askerstudio.table.Parameters;
import az.askerstudio.table.Table;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(new Parameters(100000, 12.9, 12));
        System.out.println(table.toString());
    }
}
