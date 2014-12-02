package sust.bookshelves.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sm19 & MahadiHasanNahid
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description"),
    @NamedQuery(name = "Book.findByYear", query = "SELECT b FROM Book b WHERE b.year = :year"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<Readallready> readallreadyList;
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    @ManyToOne(optional = false)
    private Author authorId;
    @JoinColumn(name = "catagory_id", referencedColumnName = "catagory_id")
    @ManyToOne(optional = false)
    private Catagory catagoryId;
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    @ManyToOne(optional = false)
    private Publisher publisherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<Suggestion> suggestionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Rating rating;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<Wanttoread> wanttoreadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<Reading> readingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<Favourite> favouriteList;

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId, int year, String title) {
        this.bookId = bookId;
        this.year = year;
        this.title = title;
    }

    public Integer getBookId() {
        return bookId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getBookId();
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<Readallready> getReadallreadyList() {
        return readallreadyList;
    }

    public void setReadallreadyList(List<Readallready> readallreadyList) {
        this.readallreadyList = readallreadyList;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public Catagory getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Catagory catagoryId) {
        this.catagoryId = catagoryId;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    @XmlTransient
    public List<Suggestion> getSuggestionList() {
        return suggestionList;
    }

    public void setSuggestionList(List<Suggestion> suggestionList) {
        this.suggestionList = suggestionList;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @XmlTransient
    public List<Wanttoread> getWanttoreadList() {
        return wanttoreadList;
    }

    public void setWanttoreadList(List<Wanttoread> wanttoreadList) {
        this.wanttoreadList = wanttoreadList;
    }

    @XmlTransient
    public List<Reading> getReadingList() {
        return readingList;
    }

    public void setReadingList(List<Reading> readingList) {
        this.readingList = readingList;
    }

    @XmlTransient
    public List<Favourite> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(List<Favourite> favouriteList) {
        this.favouriteList = favouriteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Book[ bookId=" + bookId + " ]";
    }

}
