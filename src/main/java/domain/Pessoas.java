package domain;

import javax.persistence.*;
// o javax persistence, pois o hibernate é a implementação e
// vai ser pego automatimente
import java.io.Serializable;

@Entity
public class Pessoas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    public Pessoas() {

    }

    public Pessoas(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

}
