package guru.springframeworkk.bootstrap;

import guru.springframeworkk.domain.Author;
import guru.springframeworkk.domain.Book;
import guru.springframeworkk.domain.Publisher;
import guru.springframeworkk.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by A707937 on 25-07-2020.
 */
@Component
public class BootStrapData implements CommandLineRunner{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Great Publisher");
        publisher.setAddressLine1("address line");
        publisher.setCity("Bangalore");
        publisher.setState("Bangalore");
        publisher.setZip("111222");

        publisherRepository.save(publisher);

        //First Book
        Author sudhakar = new Author("Sudhakar", "Dhayalan");
        Book preciousBook = new Book("preciousBook", "12345");
        sudhakar.getBooks().add(preciousBook);
        preciousBook.getAuthors().add(sudhakar);

        preciousBook.setPublisher(publisher);
        publisher.getBooks().add(preciousBook);

        authorRepository.save(sudhakar);
        bookRepository.save(preciousBook);
        publisherRepository.save(publisher);

        //First Book
        /*Author sudha = new Author("Sudhakar", "Sreelakshmi");
        Book precious = new Book("preciousBook", "12345");
        sudhakar.getBooks().add(precious);
        precious.getAuthors().add(sudhakar);

        precious.setPublisher(publisher);
        publisher.getBooks().add(precious);

        authorRepository.save(sudha);
        bookRepository.save(precious);
        publisherRepository.save(publisher);*/

        //Second Book
        Author kull = new Author("kull", "mark");
        Book wonderfulBook = new Book("wonderfulBook", "23456");
        kull.getBooks().add(wonderfulBook);
        wonderfulBook.getAuthors().add(kull);

        wonderfulBook.setPublisher(publisher);
        publisher.getBooks().add(wonderfulBook);

        authorRepository.save(kull);
        bookRepository.save(wonderfulBook);
        publisherRepository.save(publisher);

        System.out.println("Application started in Bootstrap");
        System.out.println("Number of Publisher: " + publisherRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of books published by Publisher: " + publisher.getBooks().size());
    }
}
