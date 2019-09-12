package forum1.demo.controller.Model;

public class User {

    private Integer id;
    private String account_Id;
    private String name;
    private String token;
    private Long gmt_Creat;
    private Long gmt_Modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(String account_Id) {
        this.account_Id = account_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmt_Creat() {
        return gmt_Creat;
    }

    public void setGmt_Creat(Long gmt_Creat) {
        this.gmt_Creat = gmt_Creat;
    }

    public Long getGmt_Modified() {
        return gmt_Modified;
    }

    public void setGmt_Modified(Long gmt_Modified) {
        this.gmt_Modified = gmt_Modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account_Id='" + account_Id + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", gmt_Creat=" + gmt_Creat +
                ", gmt_Modified=" + gmt_Modified +
                '}';
    }
}
