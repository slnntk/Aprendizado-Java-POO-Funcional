package colecoesExercicioResolvido.entities;


import java.time.Instant;

public class User implements Comparable<User>{

    private String name;
    private Instant instant;

    public User(String name, Instant instant) {
        this.name = name;
        this.instant = instant;
    }

    @Override
    public String toString() {
        return name + " " + instant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return getName() != null ? getName().equals(user.getName()) : user.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getInstant() {
        return instant;
    }
    @Override
    public int compareTo(User user) {
        return getName().compareTo(user.getName());
    }
}
