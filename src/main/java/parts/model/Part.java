package parts.model;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    private String name;
    private boolean required;
    private int countInt;

    public int getCountInt() {
        return countInt;
    }

    public void setCountInt(int countInt) {
        this.countInt = countInt;
    }

    public PartType getType() {
        return type;
    }

    public void setType(PartType type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    private PartType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean optional) {
        this.required = optional;
    }

    public int getCount() {
        return countInt;
    }

    public void setCount(int countInt) {
        this.countInt = countInt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
