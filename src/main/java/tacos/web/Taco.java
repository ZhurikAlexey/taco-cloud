package tacos.web;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Value("#{taco.name.min.size}")
    static String minSize;
    //static final String str= "Name must be at least" + minSize + " characters long";
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    private List ingredients;
    public Taco() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Taco;
    }

}
