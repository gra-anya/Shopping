import java.util.Objects;

public class Buyer {
    private String email;
    private String name;


    public Buyer(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(email, buyer.email) && Objects.equals(name, buyer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name);
    }
}
