package com.example.pierre_antoine.diabete;

import java.util.ArrayList;

/**
 *	<b>Protocole est la classe représentant les protocoles à suivre pour faire les calculs</b>
 *<p>Un protocole est caractérisé par les informations suivantes :
 * <ul>
 *     <li>un numero</li>
 *     <li>une liste des protocoles</li>
 * </ul>
 * </p>
 *
 * @see MapProtocoles
 *
 * @author Pierre-Antoine
 * @version 3.0
 *
 */
public class Protocole {
	/**
	 * le numero du Protocole.
	 */
	private int numeroProtocole;
	/**
	 * La liste des glycémie insuline
	 *
	 */
	private ArrayList<GlycemieInsuline> lesGlycemieInsuline;

	/**
	 *Constructeur Protocole
	 * <p>
	 *     A la construction d'un objet Protocole, la liste des GlycemieInsuline est créée
	 * </p>
	 *
	 * @param unNumero
	 * 		Le numero unique du protocole
     */
	public Protocole(int unNumero)	{
		this.numeroProtocole = unNumero;
		lesGlycemieInsuline = new ArrayList<GlycemieInsuline>();
	}

	/**
	 * Retourne le numero du protocole
	 *
	 * @return
	 * 		le numero du protocole
     */
	public int getNumeroProtocole()	{
		return this.numeroProtocole;
	}

	/**
	 * Ajoute une GlycemieInsuline à la liste lesGlycemieInsuline
	 *
	 * @param uneGlycemieInsuline
	 * 		Le nouvel element
     */
	public void ajouter(GlycemieInsuline uneGlycemieInsuline)	{
		this.lesGlycemieInsuline.add(uneGlycemieInsuline);
	}

	/**
	 * Retourne l'insuline en fonction de la glycemie
	 *
	 * @param uneGlycemie
	 * 		La glycemie donnée
	 * @return
	 * 		l'insuline en fonction de la glycémie donnée
     */
	public int insuline(double uneGlycemie)
	{
		//Renvoie le nombre d'unités d'insuline en fonction de la glycémie
		int retour=0;
		for (GlycemieInsuline g:this.lesGlycemieInsuline) {

			if(uneGlycemie>=g.getGlycemieInf() && uneGlycemie<g.getGlycemieSup()){
				retour=g.getInsuline();
			}
		}
		return(retour);
	}
}
