
package config;

/**
 *
 * @author Hp
 */
public class Session {
    
    private static Session instance;
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String username;
    private String type;
    private String status;
    private int number;
    
    private Session(){
        
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public static  synchronized Session getInstance() {
        if(instance == null){
            instance = new Session();
        }
        return instance;
    }
    

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
