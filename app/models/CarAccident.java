package models;





import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ftominc on 12/02/15.
 */
@Entity
public class CarAccident extends Model{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String neighborhood;
    private String street;
    private String number;
    private String crossroad;
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Victim> victims;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;
    private String cause;
    private Long cod_rgo;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCod_rgo() {
        return cod_rgo;
    }

    public void setCod_rgo(Long cod_rgo) {
        this.cod_rgo = cod_rgo;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCrossroad() {
        return crossroad;
    }

    public void setCrossroad(String crossroad) {
        this.crossroad = crossroad;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Victim> getVictims() {
        return victims;
    }

    public void setVictims(List<Victim> victims) {
        this.victims = victims;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
