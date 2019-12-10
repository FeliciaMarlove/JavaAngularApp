package be.technofuturtic.javaangularapp.utilitaires;

public class AuthentificationDto {
    private String email;
    private String password;

    public AuthentificationDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthentificationDto() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
