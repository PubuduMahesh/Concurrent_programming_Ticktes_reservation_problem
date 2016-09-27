/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreseravationsystem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author pubudurw
 */
class MainServer {
    private static int ticketAmount = 300;
    private int ticketPrice = 500;
    private int remainingTicket = ticketAmount;
    private Semaphore ticketCounter = new Semaphore(1);
    private static int income = 0;

    void doReservation(int ticketPurchased) throws InterruptedException {
        ticketCounter.acquire();//acqure the lock to do reservation
        if(remainingTicket > ticketPurchased){//if available tickets are enough
            remainingTicket = remainingTicket-ticketPurchased;//decrement the available ticket
            income = income + ticketPurchased * ticketPrice;     //increase the income   
            System.out.println(ticketPurchased+" has been purchased.");
            System.out.println("Total Income: "+income);
            System.out.println(remainingTicket+" tickets are available.");
            System.out.println("\n");
        }
        else if(remainingTicket < ticketPurchased){//if available tickets are not enough
            income = income + remainingTicket * ticketPrice;//sell all the tickets
            System.out.println("There are only remaining "+remainingTicket+" tickets. So only selling "+remainingTicket);
            System.out.println("Total Income "+income);
            remainingTicket = 0;//remaining tickets are set to zero
        }
        if(remainingTicket == 0){//if there is no tickets available
            System.out.println("/n");
            System.out.println("sorry! sold out.");
            System.exit(1);//terminate the system.
        }
        ticketCounter.release();
    }      
}