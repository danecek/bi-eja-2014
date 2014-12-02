/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author danecek
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void tisk(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        tisk("HW");    //     System.out.println("HW");
        System.out.println("Current Time(ms): " + System.currentTimeMillis());
        Object o = null;
        System.out.println("neco: " + System.class + 'c' + '\n');
        System.out.printf("2 * %d = %d\n", 10, 20);

        // TODO code application logic here
    }

}
