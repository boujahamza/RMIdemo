package tp.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import tp.metier.Compte;

public class BanqueRMIService extends UnicastRemoteObject implements IBanqueRemote{
	private List<Compte> listComptes = List.of(new Compte(1,2),new Compte(2,500),new Compte(3, 20));

	public BanqueRMIService() throws RemoteException {
		super();
	}

	@Override
	public double conversion(double montant) throws RemoteException {
		return montant/2;
	}

	@Override
	public Compte consulterCompte(int code) throws RemoteException {
		for(Compte compte: listComptes()) {
			if(compte.getCode() == code) {
				return compte;
			}
		}
		return null;
	}

	@Override
	public List<Compte> listComptes() throws RemoteException {
		return listComptes;
	}
	
}
