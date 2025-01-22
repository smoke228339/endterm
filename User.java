@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // Enum for roles (ADMIN, CLIENT)

    // getters and setters
}

public enum Role {
    ADMIN,
    CLIENT
}

