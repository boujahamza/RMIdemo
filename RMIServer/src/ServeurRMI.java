import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import tp.metier.Compte;
import tp.rmi.BanqueRMIService;

public class ServeurRMI {

	public static void main(String[] args) throws RemoteException, MalformedURLException{
		LocateRegistry.createRegistry(1099);
		BanqueRMIService banque = new BanqueRMIService();
		Naming.rebind("banque" , banque);
		Registry registry = LocateRegistry.getRegistry("localhost", 1099);
	    for (String name : registry.list()) {
	        System.out.println(name);
	    }
	}

}
