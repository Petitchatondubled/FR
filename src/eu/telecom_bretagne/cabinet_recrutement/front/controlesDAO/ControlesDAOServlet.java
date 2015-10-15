package eu.telecom_bretagne.cabinet_recrutement.front.controlesDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessageCandDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessageOffreDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauQualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreEmploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteurActiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCand;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffre;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocatorException;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ControlesDAO")
public class ControlesDAOServlet extends HttpServlet
{
	//-----------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	//-----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlesDAOServlet()
	{
		super();
	}
	//-----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Flot de sortie pour √©criture des r√©sultats.
       PrintWriter out = response.getWriter();
       testEntrepriseDAO(out);
       testNiveauQualificationDAO(out);
       testOffreEmploiDAO(out);
       testSecteurActiviteDAO(out);
       testCandidatureDAO(out);
       testMessageCand(out);
       testMessageOffre(out);
       //Remplissage base de donnÈes
       //remplissageTable();
         
	}
	
	
	private void testMessageCand(PrintWriter out) {
		
		MessageCandDAO s = new MessageCandDAO() ;
		
		try
	     {
		     s = ( MessageCandDAO) ServicesLocator.getInstance().getRemoteInterface("MessageCandDAO");
	    }
	    catch (ServicesLocatorException e)
	     {
	    	e.printStackTrace();
	    }
		out.println("\n--------------Affichage des messages candidatures--------\n");
		
		
	
		
		List<MessageCand> sa = s.findAll() ;
		int i = 1 ;
		for(MessageCand m : sa){
			out.println("Message n∞ "+i+" :");
			out.println(m.getNumMsg());
			out.println(m.getDateEnvoi());
			out.println(m.getCorpsMsg());
			out.println(m.getCandidature().getNom());
			out.println(m.getOffreEmploi().getTitre());
			i++;
		}
		
		
		
	}
	private void testMessageOffre(PrintWriter out) {
		MessageOffreDAO s = new MessageOffreDAO() ;
		
		try
	     {
		     s = ( MessageOffreDAO) ServicesLocator.getInstance().getRemoteInterface("MessageOffreDAO");
	    }
	    catch (ServicesLocatorException e)
	     {
	    	e.printStackTrace();
	    }
		
		out.println("\n-------------- Affichage des messages offres--------\n");
		List<MessageOffre> sa = s.findAll() ;
		
		int i=1;
		for(MessageOffre m : sa){
			out.println("Message n∞ "+i+" :");
			out.println(m.getNumMsg());
			out.println(m.getDateEnvoi());
			out.println(m.getCorpsMsg());
			out.println(m.getCandidature().getNom());
			out.println(m.getOffreEmploi().getTitre());
			i++;
		}
	}
	
	public void testEntrepriseDAO(PrintWriter out){
		// Flot de sortie pour √©criture des r√©sultats.
	    
	    
	    // R√©cup√©ration de la r√©f√©ence vers le(s) DAO(s)
			EntrepriseDAO entrepriseDAO = null;
	    try
	    {
		    entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
	    }
	    catch (ServicesLocatorException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    
	    out.println("\n-------------- EntrepriseDAO CONTROL --------\n");
		
			
			// Contr√¥le(s) de fonctionnalit√©s.
			out.println("Liste des entreprises :\n");
			List<Entreprise> entreprises = entrepriseDAO.findAll();
			
			int i = 1 ;
			for(Entreprise e : entreprises)
			{
				
				out.println("Entreprise n∞ "+i+" :");
				out.println(e.getId());
				out.println(e.getNom());
				out.println(e.getDescriptif());
				out.println(e.getAdressePostale());
				out.println();
				i++;
			}
			
		
	}
	
	public void testNiveauQualificationDAO(PrintWriter out){
		// Flot de sortie pour √©criture des r√©sultats.
	    
	    
	    // R√©cup√©ration de la r√©f√©ence vers le(s) DAO(s)
			NiveauQualificationDAO niveauQualificationDAO = null;
	    try
	    {
		    niveauQualificationDAO = (NiveauQualificationDAO) ServicesLocator.getInstance().getRemoteInterface("NiveauQualificationDAO");
	    }
	    catch (ServicesLocatorException e)
	    {
	    	e.printStackTrace();
	    }
	     
	    out.println("\n-------------- NiveauQualificationDAO CONTROL --------\n");
	    List<NiveauQualification> nvx = niveauQualificationDAO.findAll() ;
	    int i=1;
	    for(NiveauQualification n : nvx){
	    	out.println("Niveau de qualification n∞ "+i+" :");
	    	out.println(n.getIntitule());
	    	i++;
	    }
	}
	
	
	public void testOffreEmploiDAO(PrintWriter out){
		
		OffreEmploiDAO offre = new OffreEmploiDAO() ;
		EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
		try
	     {
		     offre = (OffreEmploiDAO) ServicesLocator.getInstance().getRemoteInterface("OffreEmploiDAO");
		     entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
	    }
	    catch (ServicesLocatorException e)
	     {
	    	e.printStackTrace();
	    }
		out.println("\n-------------- OffreEmploiDAO CONTROL --------\n");
		List<OffreEmploi> offres = offre.findAll() ;
		int i = 1 ;
		for(OffreEmploi o : offres){
			out.println("Offre n∞ "+i+" :");
			out.println(o.getTitre());
			out.println(o.getDescriptif());
			out.println(o.getProfilRecheche());
			out.println(o.getDateDepot());
			Set<SecteurActivite> a = o.getSecteurActivites();
			out.println("Affichage des secteurs d'activites");
			int j=1;
			for(SecteurActivite s : a){
				out.println("Secteur n∞ "+j+" :");
				out.println(" -->"+s.getIntitule());
				j++;
			}
			out.println(o.getNiveauQualification().getIntitule());
			out.println(o.getEntreprise().getNom());
			
		}

		out.println("\n-------------- Test mÈthode offreByEntreprise --------\n");
		Entreprise entreprise = entrepriseDAO.findById(1);
		List<OffreEmploi> off = offre.getOffreByEntreprise(entreprise.getId());
		out.println("Offre(s) de l'enteprise "+entreprise.getNom());
		for(OffreEmploi of : off){
			out.println(of.getTitre());
		};
		
		out.println("\n-------------- Test mÈthode offreByNiveauxANDActivites --------\n");
		
		NiveauQualificationDAO niveauQualificationDAO = null;
		SecteurActiviteDAO s = null ;
	    try
	    {
		    niveauQualificationDAO = (NiveauQualificationDAO) ServicesLocator.getInstance().getRemoteInterface("NiveauQualificationDAO");
		    s = (SecteurActiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteurActiviteDAO");
	    }
	    catch (ServicesLocatorException e)
	    {
	    	e.printStackTrace();
	    }
		NiveauQualification q = niveauQualificationDAO.findById("BAC+5");
		SecteurActivite sec = s.findById("Informatique");
		
		List<OffreEmploi> offf = offre.offreByActANDQuali(sec.getIntitule(),q.getIntitule());
		out.println("Offre(s) de l'enteprise "+entreprise.getNom());
		for(OffreEmploi of : offf){
			out.println(of.getTitre());
		}
	}
	
	public void testSecteurActiviteDAO(PrintWriter out){
		
	    SecteurActiviteDAO s = new SecteurActiviteDAO() ;
		
		try
	     {
		     s = ( SecteurActiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteurActiviteDAO");
	    }
	    catch (ServicesLocatorException e)
	     {
	    	e.printStackTrace();
	    }
		out.println("\n-------------- SecteurActiviteDAO CONTROL --------\n");
		List<SecteurActivite> sa = s.findAll() ;
		int i=1;
		for(SecteurActivite se : sa){
			out.println("Secteur Activite n∞ "+i+" :");
			out.println(se.getIntitule());
			i++;
		}
		
		
		
	}
	public void testCandidatureDAO(PrintWriter out){
		// Flot de sortie pour √©criture des r√©sultats.
	    
	    
	    // R√©cup√©ration de la r√©f√©ence vers le(s) DAO(s)
			CandidatureDAO candidatureDAO = null;
	    try
	    {
		    candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("CandidatureDAO");
	    }
	    catch (ServicesLocatorException e)
	    {
	    	e.printStackTrace();
	    }
	    
	   

	    
		
	    	out.println("\n-------------- CandidatureDAO CONTROL --------\n");
			// Contr√¥le(s) de fonctionnalit√©s.
			out.println("Liste des candidatures :");
			List<Candidature> candidatures = candidatureDAO.findAll();
			
			for(Candidature entreprise : candidatures)
			{
				out.println(entreprise.getNom());
			}
			out.println();
			int i = 1 ;
			for(Candidature e : candidatures)
			{
				
				out.println("Obtention de la candidature n∞ "+i+" :");
				out.println(e.getNom());
				out.println(e.getPrenom());
				out.println(e.getAdresseMail());
				out.println(e.getAdressePostale());
				out.println(e.getCv());
				out.println(e.getNiveauQualification().getIntitule());
				out.println("Affichage des secteurs d'activitÈs");
				int j=1;
				for(SecteurActivite s : e.getSecteurActivites()){
					out.println("Obtention du secteur n∞ "+j+" :");
					out.println(s.getIntitule());
					j++;
				}
				out.println(e.getDateDepot());
				out.println(e.getDateNaiss());	
				out.println();
				i++;
			}
			
			out.println("\n-------> Test mÈthode liste de candidats par secteur et niveauQualification");
			NiveauQualificationDAO niveauQualificationDAO = null;
			SecteurActiviteDAO s = null ;
		    try
		    {
			    niveauQualificationDAO = (NiveauQualificationDAO) ServicesLocator.getInstance().getRemoteInterface("NiveauQualificationDAO");
			    s = (SecteurActiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteurActiviteDAO");
		    }
		    catch (ServicesLocatorException e)
		    {
		    	e.printStackTrace();
		    }
			NiveauQualification q = niveauQualificationDAO.findById("BAC+5");
			SecteurActivite sec = s.findById("Informatique");
			
			List<Candidature> cand = candidatureDAO.candidatByActANDQuali(sec.getIntitule(), q.getIntitule());
			for(Candidature ca : cand){
				out.println(ca.getNom());
			}
			
	}
	
private void remplissageTable() {
		
		OffreEmploiDAO offre = new OffreEmploiDAO() ;
		EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
		NiveauQualificationDAO niveauQualificationDAO = new NiveauQualificationDAO();
		SecteurActiviteDAO s = new SecteurActiviteDAO();
		CandidatureDAO candidatureDAO = new CandidatureDAO();
		try
	     {
		     offre = (OffreEmploiDAO) ServicesLocator.getInstance().getRemoteInterface("OffreEmploiDAO");
		     entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
		     niveauQualificationDAO = (NiveauQualificationDAO) ServicesLocator.getInstance().getRemoteInterface("NiveauQualificationDAO");
		     s = ( SecteurActiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteurActiviteDAO");
		     candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("CandidatureDAO");
	    }
	    catch (ServicesLocatorException e)
	     {
	    	e.printStackTrace();
	    }
		
//		OffreEmploi o = new OffreEmploi();
//		
//		
//		o.setDateDepot(new Date());
//		o.setDescriptif("Professeur des Ècoles en lozere");
//		Entreprise entreprise = entrepriseDAO.findById(1) ;
//		o.setEntreprise(entreprise);
//		NiveauQualification niveau = niveauQualificationDAO.findById("BAC+5");
//		o.setNiveauQualification(niveau);
//		SecteurActivite sec = s.findById("Education");
//		Set<SecteurActivite> ss = new HashSet<SecteurActivite>();
//		ss.add(sec);
//		o.setSecteurActivites(ss);
//		o.setProfilRecheche("Une pÈdagogie et un go˚t pour la nature est nÈcessaire");
//		o.setTitre("Instit'");
//		o = offre.persist(o);
//		sec.getOffreEmplois().add(o);
//		s.update(sec);
	
//		Candidature cand = new Candidature() ;
//		cand.setAdresseMail("moha@tb.com");
//		cand.setAdressePostale("Meknes");
//		cand.setCv("Je suis une personne motivÈ, avec un bac + 5 mais trop bavard");
//		cand.setDateDepot(new Date());
//		cand.setDateNaiss(new Date());
//		cand.setNom("Moha");
//		cand.setPrenom("BENDA");
//		NiveauQualification niveau = niveauQualificationDAO.findById("BAC+5");
//		cand.setNiveauQualification(niveau);
//		Set<SecteurActivite> ss = new HashSet<SecteurActivite>();
//		SecteurActivite sec = s.findById("Informatique");
//		SecteurActivite sec2 = s.findById("Education");
//		SecteurActivite sec3 = s.findById("Transport");
//		ss.add(sec);
//		ss.add(sec2);
//		ss.add(sec3);
//		cand.setSecteurActivites(ss);
//		cand = candidatureDAO.persist(cand);
//		sec.getCandidatures().add(cand);
//		sec2.getCandidatures().add(cand);
//		sec3.getCandidatures().add(cand);
//		s.update(sec);
//		s.update(sec2);
//		s.update(sec3);
		
//		Entreprise entreprise = new Entreprise() ;
//		entreprise.setAdressePostale("Toulouse");
//		entreprise.setDescriptif("Premiere avionneur europeen , et bientÙt mondiale");
//		entreprise.setNom("AirBus");
//		entrepriseDAO.persist(entreprise);
		
		
		
	}
}
