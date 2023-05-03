package com.project.IshopPfe.dto;

import java.sql.Date;

public class LivraisonRequest {
    public Date dateLivraison;
    public double solde;
    public Long ste_livraison_id;

    public LivraisonRequest( Date dateLivraison, double solde, Long ste_livraison_id) {
        this.dateLivraison = dateLivraison;
        this.solde = solde;
        this.ste_livraison_id = ste_livraison_id;
    }
}
