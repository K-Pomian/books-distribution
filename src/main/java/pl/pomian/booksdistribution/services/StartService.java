package pl.pomian.booksdistribution.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.pomian.booksdistribution.repositories.*;
import pl.pomian.booksdistribution.repositories.entities.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

@Service
public class StartService {

    private BookRepository bookRepository;
    private CustomerRepository customerRepository;
    private RegistryRepository registryRepository;
    private LibraryRepository libraryRepository;
    private SellerRepository sellerRepository;

    @Autowired
    public StartService(
            BookRepository bookRepository,
            CustomerRepository customerRepository,
            RegistryRepository registryRepository,
            LibraryRepository libraryRepository,
            SellerRepository sellerRepository
    ) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.registryRepository = registryRepository;
        this.libraryRepository = libraryRepository;
        this.sellerRepository = sellerRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        // Create books

        Book book1 = new Book();
        book1.setIsbn("9788382891805");
        book1.setName("Dawno temu w Warszawie");
        book1.setAuthor("Jakub Zulczyk");
        book1.setPublisher("Swiat Ksiazki");
        book1.setReleaseDate(LocalDate.of(2023, 10, 16));
        book1.setPrice(BigDecimal.valueOf(38.94d));

        Book book2 = new Book();
        book2.setIsbn("9788382892543");
        book2.setName("Cyrk nocy");
        book2.setAuthor("Erin Morgenstern");
        book2.setPublisher("Swiat Ksiazki");
        book2.setReleaseDate(LocalDate.of(2023, 10, 16));
        book2.setPrice(BigDecimal.valueOf(29.19d));

        Book book3 = new Book();
        book3.setIsbn("9788383520773");
        book3.setName("Znachor");
        book3.setAuthor("Tadeusz Dołega-Mostowicz");
        book3.setPublisher("Proszynski Media");
        book3.setReleaseDate(LocalDate.of(2023, 10, 17));
        book3.setPrice(BigDecimal.valueOf(27.90d));

        bookRepository.saveAll(Arrays.asList(book1, book2, book3));

        // Create customers

        Customer customer1 = new Customer();
        customer1.setName("Mariusz");
        customer1.setAddress("Myslenicka 734");
        customer1.setPhoneNumber("+48888666333");
        customer1.setEmailAddress("email@gmail.com");

        Customer customer2 = new Customer();
        customer2.setName("Konrad");
        customer2.setAddress("Sloneczna 11");
        customer2.setPhoneNumber("+48945239426");
        customer2.setEmailAddress("email2@gmail.com");

        Customer customer3 = new Customer();
        customer3.setName("Dominik");
        customer3.setAddress("Trzemesnia 98");
        customer3.setPhoneNumber("+48974587526");
        customer3.setEmailAddress("email3@gmail.com");

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

        // Create libraries

        Library library1 = new Library();
        library1.setStreetName("Majowa");
        library1.setAvailableBooks(Set.of(book1, book2));

        Library library2 = new Library();
        library2.setStreetName("Sobieskiego");
        library2.setAvailableBooks(Set.of(book2, book3));

        libraryRepository.saveAll(Arrays.asList(library1, library2));

        // Create sellers

        Seller seller1 = new Seller();
        seller1.setName("Empik");
        seller1.setWebsite("www.empik.com");
        seller1.setAvailableBooks(Set.of(book1, book2, book3));

        Seller seller2 = new Seller();
        seller2.setName("Merlin");
        seller2.setWebsite("www.merlin.pl");
        seller2.setAvailableBooks(Set.of(book1, book3));

        sellerRepository.saveAll(Arrays.asList(seller1, seller2));

        // Create registries

        Registry registry1 = new Registry();
        registry1.setBook(book1);
        registry1.setCustomer(customer1);
        registry1.setLibrary(library2);

        Registry registry2 = new Registry();
        registry2.setBook(book1);
        registry2.setCustomer(customer2);
        registry2.setLibrary(library1);

        Registry registry3 = new Registry();
        registry3.setBook(book3);
        registry3.setCustomer(customer3);
        registry3.setSeller(seller1);

        Registry registry4 = new Registry();
        registry4.setBook(book2);
        registry4.setCustomer(customer1);
        registry4.setSeller(seller2);

        registryRepository.saveAll(Arrays.asList(registry1, registry2, registry3, registry4));
    }
}
