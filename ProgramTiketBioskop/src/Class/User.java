package Class;

public class User {
    private String username;
    private String password;
    private Order order;


    public User(String username, String password, Order order) {
        this.username = username;
        this.password = password;
        this.order = order;
    }

    public User(){}
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", order='" + getOrder() + "'" +
            "}";
    }

}
