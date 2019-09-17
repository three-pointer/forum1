package forum1.demo.controller.dto;

public class GithubUser {

    private String name;
    private Long   id;
    private String bio;
    private String avatar_Url;

    public String getAvatar_Url() {
        return avatar_Url;
    }

    public void setAvatar_Url(String avatar_Url) {
        this.avatar_Url = avatar_Url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }
}
