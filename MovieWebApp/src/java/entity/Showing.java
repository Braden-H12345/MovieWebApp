/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Braden
 */
@Entity
@Table(name = "SHOWING")
@NamedQueries({
    @NamedQuery(name = "Showing.findAll", query = "SELECT s FROM Showing s"),
    @NamedQuery(name = "Showing.findByShowingid", query = "SELECT s FROM Showing s WHERE s.showingid = :showingId"),
    @NamedQuery(name = "Showing.findByShowingTime", query = "SELECT s FROM Showing s WHERE s.showingTime = :showingTime"),
    @NamedQuery(name = "Showing.findByTheaterid", query = "SELECT s FROM Showing s WHERE s.theaterid = :theaterId"),
    @NamedQuery(name = "Showing.findByTheaterIdAndMovieId", query = "SELECT s FROM Showing s WHERE s.theaterid = :theaterId AND s.movieid = :movieId")})
public class Showing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHOWINGID")
    private Integer showingid;
    @Column(name = "SHOWING_TIME")
    @Temporal(TemporalType.TIME)
    private Date showingTime;
    @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID")
    @ManyToOne
    private Movie movieid;
    @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID")
    @ManyToOne
    private Theater theaterid;

    public Showing() {
    }

    public Showing(Integer showingid) {
        this.showingid = showingid;
    }

    public Integer getShowingid() {
        return showingid;
    }

    public void setShowingid(Integer showingid) {
        this.showingid = showingid;
    }

    public Date getShowingTime() {
        return showingTime;
    }

    public void setShowingTime(Date showingTime) {
        this.showingTime = showingTime;
    }

    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    public Theater getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(Theater theaterid) {
        this.theaterid = theaterid;
    }
    
    @Transient
    public String getTimeOnly(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");   
        return sdf.format(showingTime);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (showingid != null ? showingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showing)) {
            return false;
        }
        Showing other = (Showing) object;
        if ((this.showingid == null && other.showingid != null) || (this.showingid != null && !this.showingid.equals(other.showingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Showing[ showingid=" + showingid + " ]";
    }
    
}
