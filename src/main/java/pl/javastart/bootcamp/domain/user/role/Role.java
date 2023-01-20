package pl.javastart.bootcamp.domain.user.role;

public enum Role {

    ROLE_USER("Użytkownik"), ROLE_ADMIN("Administrator");
    final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
