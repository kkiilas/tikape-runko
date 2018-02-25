/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakkaus;

public class JuomaRaakaAine {
    private Juoma annos;
    private RaakaAine raakaAine;
    private String maara;
    public JuomaRaakaAine (Juoma an, RaakaAine ra, String maara) {
        this.annos = an;
        this.raakaAine = ra;
        this.maara = maara;
    }
    public Juoma getAnnos() {
        return this.annos;
    }
    public RaakaAine getRaakaine() {
        return this.raakaAine;
    }
}
