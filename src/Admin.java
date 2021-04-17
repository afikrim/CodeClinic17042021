public class Admin {

    private String uid;
    private String name;
    private String position;

    public Admin() {
    }

    public Admin(String uid, String name, String position) {
        this.uid = uid;
        this.name = name;
        this.position = position;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
