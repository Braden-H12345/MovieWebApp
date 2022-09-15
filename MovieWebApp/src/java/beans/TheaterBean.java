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
@Named(value = "theaterBean")
@RequestScoped
public class TheaterBean {

    @EJB
    private MoviesEJB moviesEJB;
    private Integer zip;
    private Theater selectedTheater;
    private List<Movie> playingMovies;
    private String outputText = "";

    public List<Movie> getPlayingMovies() {
        return playingMovies;
    }

    public void setPlayingMovies(List<Movie> playingMovies) {
        this.playingMovies = playingMovies;
    }

    public MoviesEJB getMoviesEJB() {
        return moviesEJB;
    }

    public void setMoviesEJB(MoviesEJB moviesEJB) {
        this.moviesEJB = moviesEJB;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    
    public List<Showing> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showing> showtimes) {
        this.showtimes = showtimes;
    }
    private List<Showing> showtimes;

    public Theater getSelectedTheater() {
        return selectedTheater;
    }

    public void setSelectedTheater(Theater selectedTheater) {
        this.selectedTheater = selectedTheater;
    }
    

    public List<Theater> getResultTheaters() throws Exception {
        if(zip==null){
            return null;
        }
        else
        {
            EntityManager em = moviesEJB.getEm();
            if(em.createNamedQuery("Theater.findByZipcode").setParameter("zipcode", zip).getResultList().isEmpty())
            {
                this.outputText = "No theaters for this zip!";
            }
            if(zip.toString().length() != 5)
            {
                this.outputText = "Please input 5 digit zip code!";
            }
            return em.createNamedQuery("Theater.findByZipcode").setParameter("zipcode", zip).getResultList();
            
        }
    }


    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
    
    
    
    public List<Integer> getZips() throws Exception {
        List<Theater> theaters = getTheaters();
        List<Integer> zips = new ArrayList<Integer>();
        
        for (Theater t : theaters){
            if(!zips.contains(t.getZipcode())){
                zips.add(t.getZipcode());
            }
        }
        return zips;
    }
    
    
    public List<Theater> getTheaters() throws Exception {
        EntityManager em = moviesEJB.getEm();

        return em.createNamedQuery("Theater.findAll").getResultList();
    }
    
    public void loadTheaterPageInfo() throws Exception{
        
        EntityManager em = moviesEJB.getEm();

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> pars = 
                fc.getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(pars.get("theaterid"));
        List<Theater> theaterList = em.createNamedQuery("Theater.findByTheaterid").setParameter("theaterId", id).getResultList();
        selectedTheater = theaterList.get(0);
        showtimes = em.createNamedQuery("Showing.findByTheaterid").setParameter("theaterId", selectedTheater).getResultList();
        playingMovies = new ArrayList<Movie>();
        for(Showing s : showtimes){
            if(!playingMovies.contains(s.getMovieid())){
                playingMovies.add(s.getMovieid());
            }
        }
    }
    
    public TheaterBean() {
    }
    
}
