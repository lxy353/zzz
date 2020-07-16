import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;


/**
 * ��ϤSAX��������
 * @author jakel
 *
 */
public class XmlTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX����
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//1.��ȡ��������
		SAXParser parser = factory.newSAXParser();
		//2���ӽ������̻�ȡ������
		//3.�����ĵ�Document ע�ᴦ����
		//4.��д������
		PersonHandler handler = new PersonHandler();
		//5 ����
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"),handler);
		
		
	}

}
class PersonHandler extends DefaultHandler2{
		@Override
	public void startDocument() throws SAXException {
		System.out.println("�����ĵ���ʼ");
		super.startDocument();
	}
		@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"---������ʼ");
		super.startElement(uri, localName, qName, attributes);
	}
		@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"---��������");
		super.endElement(uri, localName, qName);
	}
		@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String string = new String(ch,start,length).trim();
		if (string.length()>0) {
			System.out.println("����Ϊ��"+string);	
		}else {
			System.out.println("����Ϊ: null");
		}
		
		super.characters(ch, start, length);
	}
		@Override
	public void endDocument() throws SAXException {
		System.out.println("�����ĵ�����");
		super.endDocument();
	}
	
}
