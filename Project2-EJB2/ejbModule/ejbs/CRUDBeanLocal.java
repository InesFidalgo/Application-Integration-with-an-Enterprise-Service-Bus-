package ejbs;

import javax.ejb.Local;

@Local
public interface CRUDBeanLocal {
	
	public  void WriteDataAdmin(String nome, String password);
	public  void DeleteAdmin(int id);
}
