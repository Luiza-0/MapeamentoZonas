
package Testee;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

public class Testee {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
			// Carregar o arquivo KML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\Luiza Gabriella\\Documents\\IC - CIM\\Zona A.kml");

			// Obter a lista de elementos "Placemark"
			NodeList placemarkList = doc.getElementsByTagName("Placemark");

			// Percorrer os elementos "Placemark"
			for (int i = 0; i < placemarkList.getLength(); i++) {
				Node placemarkNode = placemarkList.item(i);
				if (placemarkNode.getNodeType() == Node.ELEMENT_NODE) {
					Element placemarkElement = (Element) placemarkNode;

					// Verificar se o nome é "INSTITUCIONAL"
					NodeList nameList = placemarkElement.getElementsByTagName("name");
					if (nameList.getLength() > 0) {
						Node nameNode = nameList.item(0);
						String name = nameNode.getTextContent();

						if (name.equals("INSTITUCIONAL")) {
							// Obter o elemento "Polygon"
							NodeList polygonList = placemarkElement.getElementsByTagName("Polygon");
							if (polygonList.getLength() > 0) {
								Element polygonElement = (Element) polygonList.item(0);

								// Obter as coordenadas do elemento "coordinates"
								NodeList coordinatesList = polygonElement.getElementsByTagName("coordinates");
								if (coordinatesList.getLength() > 0) {
									Node coordinatesNode = coordinatesList.item(0);
									String coordinates = coordinatesNode.getTextContent().trim();

									System.out.println(name + ". Coordenadas: " + coordinates);
									System.out.println();
								}
							}
						}
					}
				}
			}
		}
}


			
		



		//			} catch (Exception e) {
		//				e.printStackTrace();
		//			}


