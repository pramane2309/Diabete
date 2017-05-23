package com.example.pierre_antoine.diabete;

/**
 * <b>GlycemieInsuline est la classe représentant l'insuline à afficher en fonction de la glycémie donnée</b>
 * <p>
 *     Une GlycémieInsuline est caractérisé par les informations suivantes :
 *     <ul>
 *         <li>Une glycémie inférieure</li>
 *         <li>Une glycémie supérieure</li>
 *         <li>une insuline</li>
 *     </ul>
 *</p>
 * <p>l'utilisateur doit inscrire un taux de glycémie. Si la Glycémie est entre la glycémie inférieure et la glycémie supérieure alors l'insuline correspondant s'affiche</p>
 *
 *
 *
 * @author Pierre-Antoine
 * @version 3.0
 */

public class GlycemieInsuline {
	/**
	 * la glycémie inférieure. Cette glycémie est modifiable.
	 *
	 */
	private double glycemieInf;
	/**
	 * la glycémie supérieure. Cette glycémie est modifiable.
	 *
	 */
	private double glycemieSup;
	/**
	 * l'insuline à afficher
	 *
	 */
	private int insuline;

	/**
	 * Constructeur GlycemieInsuline.
	 *
	 * @param uneGlycemieInf
	 * 		La glycémie Inférieure de GlycemieInsuline
	 * @param uneGlycemieSup
	 * 		La glycémie Supérieure de GlycemieInsuline
	 * @param uneInsuline
	 * 		L'insuline de GlycemieInsuline
     */
	//Constructeur
	public GlycemieInsuline(double uneGlycemieInf, double uneGlycemieSup, int uneInsuline) {
		this.glycemieInf = uneGlycemieInf;
		this.glycemieSup = uneGlycemieSup;
		this.insuline = uneInsuline;
	}

	/**
	 * Retourne la glycémie inférieure de GlycemieInsuline
	 *
	 * @return la glycémie inférieure
     */
	//Accesseurs
	public double getGlycemieInf() {
		return this.glycemieInf;
	}
	/**
	 * Retourne la glycémie inférieure de GlycemieInsuline
	 *
	 * @return la glycémie supérieure
	 */
	public double getGlycemieSup() { return this.glycemieSup; }
	/**
	 * Retourne l'insuline de GlycemieInsuline
	 *
	 * @return l'insuline
	 */
	public int getInsuline() {
		return this.insuline;
	}

}