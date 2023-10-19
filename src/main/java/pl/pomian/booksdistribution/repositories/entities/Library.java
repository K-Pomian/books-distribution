package pl.pomian.booksdistribution.repositories.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "libraries")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private Set<Book> availableBooks;
    @OneToMany(mappedBy = "library")
    private Set<Registry> registries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(Set<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public Set<Registry> getRegistries() {
        return registries;
    }

    public void setRegistries(Set<Registry> registries) {
        this.registries = registries;
    }
}
