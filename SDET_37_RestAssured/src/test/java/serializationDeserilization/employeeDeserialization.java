package serializationDeserilization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeSerialization.PojoClass;

public class employeeDeserialization {
	public static void main(String[] args) throws Throwable, Throwable, Throwable {

		
		//create object for object mapper
		ObjectMapper objm=new ObjectMapper();
		
		//create an object for pojo class
		PojoClass p1=objm.readValue(new File("./sumanth.json"), PojoClass.class);
		
		System.out.println(p1.getEmpName()+"\t"+p1.getEmpID()+"\t"+p1.getEmail()+"\t"+p1.getPhNum());

		

	}

}
