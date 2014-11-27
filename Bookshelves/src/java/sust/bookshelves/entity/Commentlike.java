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
@Table(name = "commentlike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentlike.findAll", query = "SELECT c FROM Commentlike c"),
    @NamedQuery(name = "Commentlike.findByCommentlikeId", query = "SELECT c FROM Commentlike c WHERE c.commentlikeId = :commentlikeId")})
public class Commentlike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentlike_id")
    private Integer commentlikeId;
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    @ManyToOne(optional = false)
    private Comment commentId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Commentlike() {
    }

    public Commentlike(Integer commentlikeId) {
        this.commentlikeId = commentlikeId;
    }

    public Integer getCommentlikeId() {
        return commentlikeId;
    }

    public void setCommentlikeId(Integer commentlikeId) {
        this.commentlikeId = commentlikeId;
    }

    public Comment getCommentId() {
        return commentId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getCommentlikeId();
    }

    public void setCommentId(Comment commentId) {
        this.commentId = commentId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentlikeId != null ? commentlikeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentlike)) {
            return false;
        }
        Commentlike other = (Commentlike) object;
        if ((this.commentlikeId == null && other.commentlikeId != null) || (this.commentlikeId != null && !this.commentlikeId.equals(other.commentlikeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Commentlike[ commentlikeId=" + commentlikeId + " ]";
    }

}
