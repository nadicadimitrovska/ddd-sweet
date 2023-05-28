package mk.ukim.finki.emt.ordermanagement.service.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserForm {
    @NotNull
    private String username;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String password;
}
