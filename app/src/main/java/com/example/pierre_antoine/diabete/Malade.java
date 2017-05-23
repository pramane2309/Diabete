package com.example.pierre_antoine.diabete;

import java.io.Serializable;

/**
 * <b>Malade est la classe représentant un malade de la société GSB</b>
 * <p>
 *     Un malade est caractérisé par les informations suivantes :
 *     <ul>
 *         <li>un identifiant unique attribué définitivement</li>
 *         <li>un nom </li>
 *         <li>un prénom</li>
 *         <li>un taux de glycémie</li>
 *     </ul>
 * </p>
 *
 * @author Pierre-Antoine
 * @version 3.0
 *
 */
public class Malade implements Serializable{
	/**
	 * L'id du malade.
	 */
	private int id;
	/**
	 * le nom du malade
	 */
	private String nom;
	/**
	 * le prénom du malade
	 */
	private String prenom;
	/**
	 * La glycémie du malade
	 */
	private double glycemie;

	/**
	 * Constructeur Malade
	 *
	 * @param unNom
	 * 		Le nom du malade
	 * @param unPrenom
	 * 		Le prénom du malade
	 * @param uneGlycemie
	 * 		La glycémie du malade
     */
	public Malade(String unNom, String unPrenom, double uneGlycemie){
		this.nom = unNom;
		this.prenom = unPrenom;
		this.glycemie = uneGlycemie; 
	}

	/**
	 * Retourne l'id du malade
	 *
	 * @return l'identifiant du malade
     */
	public int getId() {
		return this.id;
	}

	/**
	 * Met à jour l'ID du malade
	 *
	 * @param unId
	 * 		le nouvel identifiant du malade
     */
	public void setId(int unId){
		this.id = unId;
	}

	/**
	 * Retourne le nom du malade
	 *
	 * @return
	 * 		le nom du malade
     */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne le prénom du malade
	 *
	 * @return
	 * 		le prénom du malade
     */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Retourne la glycémie du malade
	 *
	 * @return
	 * 		la glycemie du malade
     */

	public double getGlycemie() {
		return this.glycemie;
	}

	/**
	 * Retourne getNom, getPrenom et getGlycémie du malade
	 *
	 * @return le nom, le prénom et la glycémie du malade
     */
	public String toString(){
		String retour="";
		retour += "nom : "+ getNom();
		retour += " prenom : "+ getPrenom();
		retour += " glycemie : "+ getGlycemie();
		return retour;
	}
}