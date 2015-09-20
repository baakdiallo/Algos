
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable amrt = new HashTable(13);
		String nom[] = {"Gueye","Basse","Lo","Ndiaye","Ngom","Diatta","Mbengue"};
		String prenom[] = {"Dahiru","Adrian","Moussa","Ndeye Masata","Diery","Boubabcar","Youga"};
		String tel[] = {"772681918","772399012","776181110","778903412","779180913","777890489","774127207"};
		for(int i = 0; i < nom.length; i++){
			amrt.insertItemIntoTheDataBase(nom[i],prenom[i],tel[i]);
		}
		amrt.displayTheDataBase();
		amrt.depositBalanceIntoTheDataBaseByPhone(1000,"778903412");
		amrt.depositBalanceIntoTheDataBaseByPhone(500,"778903412");
		amrt.withdrawalBalanceFromTheDataBaseByPhone(250,"778903412");
		amrt.displayTheDataBase();
		amrt.withdrawalBalanceFromTheDataBaseByPhone(550,"778903412");
		amrt.depositBalanceIntoTheDataBaseByPhone(1500,"778903412");
		amrt.displayTheDataBase();
		amrt.displayTheDataBase();
	}

}
