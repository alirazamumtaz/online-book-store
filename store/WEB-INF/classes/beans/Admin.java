package beans;

public class Admin {
    public String adminName;
    public String password;

    public Admin() {
        this.adminName = "";
        this.password = "";
    }

    public Admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // @Override
    public String toString() {
        return (" Name: " + this.adminName + "\n + Password: " + this.password);
    }
}
