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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByFname", query = "SELECT u FROM User u WHERE u.fname = :fname"),
    @NamedQuery(name = "User.findByLname", query = "SELECT u FROM User u WHERE u.lname = :lname"),
    @NamedQuery(name = "User.findByCountry", query = "SELECT u FROM User u WHERE u.country = :country"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhoto", query = "SELECT u FROM User u WHERE u.photo = :photo")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "photo")
    private String photo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Readallready> readallreadyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Suggestion> suggestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userUserId")
    private List<Suggestion> suggestionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Wanttoread> wanttoreadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Reading> readingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Favourite> favouriteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Follow> followList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userUserId")
    private List<Follow> followList1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId")
    private Userlogin userlogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Notification> notificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Commentlike> commentlikeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Statuslike> statuslikeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Status> statusList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String username, String fname, String country, String email, String photo) {
        this.userId = userId;
        this.username = username;
        this.fname = fname;
        this.country = country;
        this.email = email;
        this.photo = photo;
    }

    public Integer getUserId() {
        return userId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getUserId();
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlTransient
    public List<Readallready> getReadallreadyList() {
        return readallreadyList;
    }

    public void setReadallreadyList(List<Readallready> readallreadyList) {
        this.readallreadyList = readallreadyList;
    }

    @XmlTransient
    public List<Suggestion> getSuggestionList() {
        return suggestionList;
    }

    public void setSuggestionList(List<Suggestion> suggestionList) {
        this.suggestionList = suggestionList;
    }

    @XmlTransient
    public List<Suggestion> getSuggestionList1() {
        return suggestionList1;
    }

    public void setSuggestionList1(List<Suggestion> suggestionList1) {
        this.suggestionList1 = suggestionList1;
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

    @XmlTransient
    public List<Follow> getFollowList() {
        return followList;
    }

    public void setFollowList(List<Follow> followList) {
        this.followList = followList;
    }

    @XmlTransient
    public List<Follow> getFollowList1() {
        return followList1;
    }

    public void setFollowList1(List<Follow> followList1) {
        this.followList1 = followList1;
    }

    public Userlogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(Userlogin userlogin) {
        this.userlogin = userlogin;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient
    public List<Commentlike> getCommentlikeList() {
        return commentlikeList;
    }

    public void setCommentlikeList(List<Commentlike> commentlikeList) {
        this.commentlikeList = commentlikeList;
    }

    @XmlTransient
    public List<Statuslike> getStatuslikeList() {
        return statuslikeList;
    }

    public void setStatuslikeList(List<Statuslike> statuslikeList) {
        this.statuslikeList = statuslikeList;
    }

    @XmlTransient
    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.User[ userId=" + userId + " ]";
    }

}
