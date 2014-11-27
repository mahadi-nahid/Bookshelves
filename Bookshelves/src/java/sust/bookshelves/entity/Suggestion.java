/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.bookshelves.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sm19
 */
@Entity
@Table(name = "suggestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suggestion.findAll", query = "SELECT s FROM Suggestion s"),
    @NamedQuery(name = "Suggestion.findBySuggestionId", query = "SELECT s FROM Suggestion s WHERE s.suggestionId = :suggestionId")})
public class Suggestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "suggestion_id")
    private Integer suggestionId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Book bookId;
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userUserId;

    public Suggestion() {
    }

    public Suggestion(Integer suggestionId) {
        this.suggestionId = suggestionId;
    }

    public Integer getSuggestionId() {
        return suggestionId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getSuggestionId();
    }

    public void setSuggestionId(Integer suggestionId) {
        this.suggestionId = suggestionId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public User getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(User userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suggestionId != null ? suggestionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suggestion)) {
            return false;
        }
        Suggestion other = (Suggestion) object;
        if ((this.suggestionId == null && other.suggestionId != null) || (this.suggestionId != null && !this.suggestionId.equals(other.suggestionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Suggestion[ suggestionId=" + suggestionId + " ]";
    }

}
