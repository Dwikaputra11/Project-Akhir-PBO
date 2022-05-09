package Class;

import java.util.Date;

class Order extends Film{
    private String name;
    private Date date;
    
    public Order(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}