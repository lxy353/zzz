public class User {
    int id; // id
    String name; // name
    String pwd; // password
    public User() {
 
    }
    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    /*
     * overload
     */
    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    } 
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User(101, "lxy");
        User u3 = new User(100, "lxy", "123456");     
    }
}