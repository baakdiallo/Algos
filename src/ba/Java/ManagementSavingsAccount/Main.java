
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nom[] = {"Gueye","Basse","Lo","Ndiaye","Ngom","Diatta","Mbengue"};
		String prenom[] = {"Dahiru","Adrian","Moussa","Ndeye Masata","Diery","Boubabcar","Youga"};
		String tel[] = {"772681918","772399012","776181110","778903412","779180913","777890489","774127207"};
		int nbr = nom.length;
		DataBase uadb = new DataBase(nbr);
		for(int i = 0; i < nbr; i++){
			 Item item = new Item(new Customer(nom[i],prenom[i],tel[i]));
			 uadb.addRecordingIntoTheDataBase(item);
		}
		uadb.displayTheDataBase();
		uadb.addAmount("Dahiru",1000);
		uadb.addAmount("Dahiru",1000);
		uadb.addAmount("Dahiru",1000);
		uadb.delAmount("Dahiru",200);
		uadb.addAmount("Ndeye Masata",2000);
		uadb.addAmount("Ndeye Masata",2000);
		uadb.addAmount("Ndeye Masata",1000);
		uadb.addAmount("Youga",2000);
		uadb.addAmount("Youga",4000);
		uadb.addAmount("Adrian",8000);
		uadb.delAmount("Adrian",800);
		uadb.delAmount("Adrian",100);
		uadb.displayTheDataBase();
		uadb.displayTheDataBase();
	}

}
