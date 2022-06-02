package co.edu.unbosque.digitalartmarketplace.jpa.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "WalletHistory")
public class WalletHistory {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "fcoins")
    private Double fcoins;

    @Column(name = "registeredAt")
    private Date registeredAt;

    @ManyToOne
    @JoinColumn(name = "email")
    private UserApp userApp;

    public WalletHistory() {
    }

    public WalletHistory(String type, Double fcoins, Date registeredAt, UserApp userApp) {
        this.type = type;
        this.fcoins = fcoins;
        this.registeredAt = registeredAt;
        this.userApp = userApp;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Double getFcoins() {
        return fcoins;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }
}
