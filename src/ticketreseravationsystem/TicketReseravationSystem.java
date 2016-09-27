/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreseravationsystem;

import java.util.Random;

/**
 *
 * @author pubudurw
 */
public class TicketReseravationSystem {

    /**
     * @param args the command line arguments
     */
    private static MainServer ms = new MainServer();
    private static Random rand = new Random();
    public static void main(String[] args) throws InterruptedException{
        while (true){
            int ticketPurchased = rand.nextInt(4); // initializing number of purchase tickets
            if(ticketPurchased != 0){
                new TicketReservation (ticketPurchased,ms).start();
            }
            
        }
    }
    
}
