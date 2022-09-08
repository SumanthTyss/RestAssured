package serializationDeserilization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeSerialization.PojoClass;

public class employeeSerilaization {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {

		//create an object for pojo class
		PojoClass pojo=new PojoClass("Sumanth", "ty310987", "sumanth12897@gmail.com", 97425);

		//create object for object mapper
		ObjectMapper objm=new ObjectMapper();
		objm.writeValue(new File("./sumanth.json"), pojo);

	}

}
