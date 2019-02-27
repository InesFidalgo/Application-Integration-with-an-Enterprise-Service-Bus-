package ejbs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import data.Admin;
import data.Course;
import data.Material;
import data.Professor;
import data.Student;

@Remote
public interface CRUDBeanRemote {
	public void WriteDataProfessor(String nome, String password, Date data, String email, String alternate, String address, int tel, int internalnumber, String categoria, String office, int numerotinterno, double salario);
	public void WriteDataStudent(String nome, String password, int number, int firstYear, Date birth, String email, String alternateEmail, String address,
			int telephone);
	public void WriteDataMaterial(int idcourse, byte[] content, double size, String name) ;
	public void WriteDataCourse(String nomec);
	public void EditarAdmin(int id, String nome, String password) ;
	public void EditarProfessor(int id, String nome, String password, Date data, String email, String alternate, String address, int tel, int internalnumber, String categoria, String office, int numerotinterno, double salario);
	public void EditarStudent(int id, String nome, String password, int number, int firstYear, Date birth, String email, String alternateEmail, String address,
			int telephone);
	public void EditarMaterial(int id,int  idc, byte[] content, double size, String name) ;
	public void EditarCourse(int id,String nome,Professor professor,List<Student> alunos,List<Material> materiais); //aqui
	public void Logout(int id);
	public boolean Login(String email, String password);
	public void DeleteMaterial(int id);
	public List<Material> ListMaterials(int courseid);
	public byte[] DownloadMaterials(int id);
	public ArrayList<Student> ListStudents();
	///////////////trocar
	public void DeleteAdmin(int id);
	public void DeleteProfessor(int id);
	public void DeleteAluno(int id);
	public void DeleteCourse(int id);
	public void AddProfCourse(int id, int idc);
	public void AddStudentCourse(int ids, int idc);
	List<Professor> ListProfessors();
	List<Course> ListCourses();
	List<Material> ListMaterials();
	void EditarCourse(int id, String name);
	public List<Admin> ListAdmins();
	
	
	
}
