package pl.pomian.booksdistribution.repositories.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String website;
    @ManyToMany
    private Set<Book> availableBooks;
    @OneToMany(mappedBy = "seller")
    private Set<Registry> registries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
