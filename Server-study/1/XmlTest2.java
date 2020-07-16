import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import com.sun.java.swing.action.SaveAction;




/**
 * 熟悉SAX解析流程
 * @author jakel
 *
 */
public class XmlTest2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//1.获取解析工厂
		SAXParser parser = factory.newSAXParser();
		//2。从解析工程获取解析器
		//3.加载文档Document 注册处理器
		//4.编写处理器
		PersonHandler2 handler = new PersonHandler2();
		//5 解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"),handler);
		// get data
		List<Person> persons = handler.getPersons();
		for (Person p:persons) {
			System.out.println(p.getAge()+"-->"+p.getName());
			
		}
	}

}
class PersonHandler2 extends DefaultHandler2{
	private List<Person> persons;
	private Person person;
	private String tahString; //save
	
	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"---解析开始");
		if (null!=qName) {
			tahString=qName;
			if (tahString.equals("person")) {
				person = new Person();
			}
			tahString=null;//throw tag
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		String string = new String(ch,start,length).trim();
		if (null!=tahString) {//deal with null
		if (tahString.equals("name")) {
			person.setName(string);
		}else if (tahString.equals("age")) {
			if (string.length()>0) {
				person.setAge(Integer.valueOf(string));
			}
		}
	}
	}
		@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"---解析结束");
		if (null!=qName) {
		if (qName.equals("person")) {
			persons.add(person);
		}
		}
	}	
		@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}

		public List<Person> getPersons() {
			return persons;
		}

		public void setPersons(List<Person> persons) {
			this.persons = persons;
		}
	
}
