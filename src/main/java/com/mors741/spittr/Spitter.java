package com.mors741.spittr;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
public class Spitter {

    private static long idGen = 0;

    @Getter @Setter private long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Getter @Setter private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @Getter @Setter private String lastName;

    @Email
    @Getter @Setter private String email;

    @NotNull
    @Size(min = 5, max = 16)
    @Getter @Setter private String username;

    @NotNull
    @Size(min = 5, max = 25)
    @Getter @Setter private String password;

    public Spitter(String firstName, String lastName, String email, String username, String password) {
        this.id = idGen++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spitter spitter = (Spitter) o;

        return id == spitter.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
