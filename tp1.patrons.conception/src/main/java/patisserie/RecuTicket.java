package patisserie;

public class RecuTicket implements TicketDessert{
    private Dessert dessert ;

    public RecuTicket(Dessert dessert){
         this.dessert = dessert;
    }

    public String getTicket(Dessert dessert){
        return  dessert.toString();
    }
}
