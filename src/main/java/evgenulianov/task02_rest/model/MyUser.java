package evgenulianov.task02_rest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Validated
public class MyUser{

    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    @Override
    public String toString(){
        return userName;
    }

}
