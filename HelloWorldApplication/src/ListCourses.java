

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

import data.Course;
import data.Material;


@XmlRootElement(name="ListCourses")
public class ListCourses {
	private List<Course> courses;


	public ListCourses() {
		this.courses = new ArrayList<>();
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course c) {
		this.courses.add(c);	
	}

	public static void main(String[] args) throws JAXBException {
		Course courses[] = {new Course("IS"), new Course("ES"), new Course("PPP")};
		Material materials[] = {new Material("book", "/usr"), new Material("slides", "/usr/slides"), new Material("exercises", "/usr/exercises")};
		
		courses[0].addMaterial(materials[0]);
		courses[0].addMaterial(materials[1]);
		courses[1].addMaterial(materials[0]);
		courses[1].addMaterial(materials[2]);
		courses[2].addMaterial(materials[1]);
		courses[2].addMaterial(materials[2]);
		
		ListCourses lc = new ListCourses();
		for (Course c : courses)
			lc.addCourse(c);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ListCourses.class);
		Marshaller m = jaxbContext.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(lc, System.out);
	}

}
