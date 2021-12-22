import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import tp.metier.Compte;
import tp.rmi.IBanqueRemote;

public class ClientRMI {
	public static void main(String[] args) {
		
		
		try {
			 IBanqueRemote stub = (IBanqueRemote)Naming.lookup("rmi://localhost:1099/banque");
			 //Methode de conversion
			 System.out.println(stub.conversion(40));
			 //Methode pour consulter un compte particulier
			 System.out.println("Consulter un compte a distance");
			 Compte compte=stub.consulterCompte(1);
			 System.out.println("Code=" +compte.getCode());
			 System.out.println("Solde en DH =" +compte.getSolde());
			 System.out.println("Date de creation du compte est =" +compte.getDateCreation());
			 //Methode pour consulter tous les comptes
			 System.out.println("la liste des comptes ");
			 List<Compte> ctps = stub.listComptes();
			 System.out.println("Afficher les informations sur les comptes ");
			 for (Compte c: ctps) { 
				 System.out.println("----------------------------");
				 System.out.println("Code=" +  c.getCode());
				 System.out.println("Solde en DH =" + c.getSolde());
				 System.out.println("la date de creation du compte =" +c.getDateCreation());
			 }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}