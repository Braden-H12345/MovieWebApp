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
@Named(value = "simulatePurchase")
@RequestScoped
public class SimulatePurchase {

    @EJB
    private MoviesEJB moviesEJB;

    /**
     * Creates a new instance of SimulatePurchase
     */
    
    
    private String cardNum;
    private Showing selectedShowing;
    private Movie selectedMovie;
    private String title;
    private String outputText ="";
    private String time = "";
    private String movie = "";

    public MoviesEJB getMoviesEJB() {
        return moviesEJB;
    }

    public void setMoviesEJB(MoviesEJB moviesEJB) {
        this.moviesEJB = moviesEJB;
    }

    public Showing getSelectedShowing() {
        return selectedShowing;
    }

    public void setSelectedShowing(Showing selectedShowing) {
        this.selectedShowing = selectedShowing;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    
    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    public SimulatePurchase() {
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    
    
    public void loadPurchasePage() throws Exception{
        EntityManager em = moviesEJB.getEm();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> pars = 
                fc.getExternalContext().getRequestParameterMap();
        Integer showID = Integer.parseInt(pars.get("showingid"));
        List<Showing> showList = em.createNamedQuery("Showing.findByShowingid").setParameter("showingId", showID).getResultList();
        selectedShowing = showList.get(0);
        List<Movie> movieList = em.createNamedQuery("Movie.findByMovieid").setParameter("movieId", selectedShowing.getMovieid().getMovieid()).getResultList();
        selectedMovie = movieList.get(0);
        
        time = selectedShowing.getTimeOnly();
        movie = selectedMovie.getTitle();
    }
    
    
    public String verify()
    {
        if(cardNum.length() == 16)
        {
            return "confirmation.xhtml";
        }
        else
            outputText = "Please input 16 digit card number!";
            return "";
    }
    
    public String returnTitle()
    {
        return movie;
    }
    
    public String returnTime()
    {
        return time;
    }
    
}
