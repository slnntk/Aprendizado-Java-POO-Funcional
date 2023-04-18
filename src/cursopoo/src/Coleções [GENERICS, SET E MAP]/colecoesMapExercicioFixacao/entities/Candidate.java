package colecoesMapExercicioFixacao.entities;

public class Candidate {

    private String name;

    public Candidate(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate candidate)) return false;

        return getName() != null ? getName().equals(candidate.getName()) : candidate.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    public String getName() {
        return name;
    }
}
