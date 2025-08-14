//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2025.08.09 à 12:12:40 PM GMT 
//


package com.groupeisi.devoirsoap.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sector" type="{http://com.groupeisi/devoirsoap/sectors}sector" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sector"
})
@XmlRootElement(name = "getSectorResponse", namespace = "http://com.groupeisi/devoirsoap/sectors")
public class GetSectorResponse {

    @XmlElement(namespace = "http://com.groupeisi/devoirsoap/sectors")
    protected Sector sector;

    /**
     * Obtient la valeur de la propriété sector.
     * 
     * @return
     *     possible object is
     *     {@link Sector }
     *     
     */
    public Sector getSector() {
        return sector;
    }

    /**
     * Définit la valeur de la propriété sector.
     * 
     * @param value
     *     allowed object is
     *     {@link Sector }
     *     
     */
    public void setSector(Sector value) {
        this.sector = value;
    }

}
