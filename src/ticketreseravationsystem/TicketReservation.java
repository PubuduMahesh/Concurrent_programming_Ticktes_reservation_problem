/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreseravationsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pubudurw
 */
public class TicketReservation extends Thread{//thread class
    
    private int ticketPurchased;
    private MainServer ms;

    TicketReservation(int ticketPurchased, MainServer ms) {
        this.ticketPurchased = ticketPurchased;
        this.ms = ms;
    }
    
    @Override
    public void run(){        
        try {
            ms.doReservation(ticketPurchased);//call to the ticket purchase method
        } catch (InterruptedException ex) {
            Logger.getLogger(TicketReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
