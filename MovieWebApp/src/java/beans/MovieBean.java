/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.MoviesEJB;
import entity.Movie;
import entity.Showing;
import entity.Theater;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Braden
 */
@Named(value = "movieBean")
@RequestScoped
public class MovieBean {

    @EJB
    private MoviesEJB moviesEJB;

    
    
     private List<Showing> showings;

    public List<Showing> getShowings() {
        return showings;
    }

    public void setShowings(List<Showing> showings) {
        this.showings = showings;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }
    private Movie selectedMovie;
    
    public MovieBean() {
    }
    
    public void loadMoviePageInfo() throws Exception
    {
       
        EntityManager em = moviesEJB.getEm();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> pars = 
                fc.getExternalContext().getRequestParameterMap();
        Integer tID = Integer.parseInt(pars.get("theaterid"));
        Integer mID = Integer.parseInt(pars.get("movieid"));
        List<Movie> movieList = em.createNamedQuery("Movie.findByMovieid").setParameter("movieId", mID).getResultList();
        setSelectedMovie(movieList.get(0));
        List<Theater> theaterList = 
                em.createNamedQuery("Theater.findByTheaterid").setParameter("theaterId", tID).getResultList();
        
        showings = em.createNamedQuery("Showing.findByTheaterIdAndMovieId").setParameter("theaterId", theaterList.get(0)).setParameter("movieId", movieList.get(0)).getResultList();
    }
    
}
