package tacos.web;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Value("#{taco.name.min.size}")
    static String minSize;
    //static final String str= "Name must be at least" + minSize + " characters long";
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="Your must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    public Taco() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Taco;
    }

}
