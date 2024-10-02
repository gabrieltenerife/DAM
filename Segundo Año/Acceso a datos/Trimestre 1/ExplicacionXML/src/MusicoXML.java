import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class MusicoXML {



	/*	
	 * Este programa lo que hace es implementar dos funciones, con las cuales se leen y escriben Musicos en un fichero
	 * XML, utilizando la API de DOM
	 */

	//En el Xml "Ctrl + Alt + L" para ordenar

			/*
			 * Escribe en un fichero XML el contenido de la lista que se le pasa como par�metro
			 */
			public void escribirXML(ArrayList<Musico> listaMusicos) {
				// Creamos el DocumentBuilderFactory, que es el objeto que crea objetos de clase DocumentBuilder
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				Document documento = null;
				
				try {
					// Creamos un documentBuilder utilizando la factory
					DocumentBuilder builder = factory.newDocumentBuilder();
					
					// Creamos nuestro �rbol DOM, en este caso vac�o
					DOMImplementation dom = builder.getDOMImplementation();
					
					// Ahora hacemos que nuestro �rbol apunte a un documento.
					// El primer par�metro representa el namespace del fichero, dejarlo a null
					// El segundo es nuestro elemento ra�z 
					// El tercero es el tipo de elemento, dejarlo a null
					
					documento = dom.createDocument(null,  "Musicos", null);
					
					// Con getDocumentElement() accedemos al elemento ra�z
					
					Element raiz = documento.getDocumentElement();
					
					/*
					 * En DOM vamos a trabajar con diversos elementos:
					 * Element: Corresponde a cada elemento (marcas) del documento
					 * Node: Corresponde a cualquier componente del documento, puede ser textual, un elemento, un atributo...
					 * Text: Se recfiere al texto que hay dentro de cada elemento
					 */
					Element nodoMusico = null, nodoNombre = null, nodoAnyo = null, nodoGenero = null;
					Text texto = null;
					
				
					
					// Ahora, por cada Musico de nuestro arrayList que nos env�an por par�metro
					for (Musico Musico : listaMusicos) {
					
						//Creamos un elemento Musico y lo a�adimos a la raiz
						nodoMusico = documento.createElement("Musico");
						raiz.appendChild(nodoMusico);
						
						//Si qusieramos a�adir un ATRIBUTO, se har�a as� (es un ejemplo) :
						//nodoMusico.setAttribute("Discografica", "Hopeless Records");
						
						// Creamos un elemento nombre y lo a�adimos al elemento Musico
						nodoNombre = documento.createElement("nombre");
						nodoMusico.appendChild(nodoNombre);
						
						texto = documento.createTextNode(Musico.getNombre());
						nodoNombre.appendChild(texto);
						
						// Creamos un elemento a�o_formacion y lo a�adimos al elemento Musico
						nodoAnyo = documento.createElement("año_formacion");
						nodoMusico.appendChild(nodoAnyo);
						
						texto = documento.createTextNode(String.valueOf(Musico.getFormacion()));
						nodoAnyo.appendChild(texto);
						
						
						// Creamos un elemento genero y lo a�adimos al elemento Musico
						nodoGenero = documento.createElement("genero");
						nodoMusico.appendChild(nodoGenero);
						
						texto = documento.createTextNode(Musico.getGenero());
						nodoGenero.appendChild(texto);
					}
					
					// Una vez tenemos nuestro �rbol DOM creado, hay que tranformarlo a nuestro fichero XML
					
					
					
					/* La clase Transformer de Java es una clase muy potente, que permite transformar
						elementos de un tipo de datos a otro: DOM a texto, DOM a String, DOM a binario...
						Este a�o s�lo pasaremos de DOM a texto, y se hace con estos m�todos.
						
						Dicha clase necesita dos par�metros, uno de tipo Source, y otro de tipo Result.
					 */
					
					
					
					

					Source source = new DOMSource(documento);
					Result resultado = new StreamResult(new File("GruposMusica.xml"));
					
					// Transformer funciona igual que Document, necesitamos una "f�brica" que cree
					// objetos de tipo Transformer, pero aqu� lo simplifico un poco m�s
					
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(source, resultado);
					
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (TransformerConfigurationException tce) {
					tce.printStackTrace();
				} catch (TransformerException te) {
					te.printStackTrace();
				}
			}
			
			/*
			 * Lee un fichero XML y muestra el contenido por pantalla
			 */
			public void leerFicheroXML() {
				
				// Creamos el DocumentBuilderFactory, que es el objeto que crea objetos de clase DocumentBuilder
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				Document documento = null;
				
				try {
					
					// Creamos un documentBuilder utilizando la factory
					DocumentBuilder builder = factory.newDocumentBuilder();
					
					/*
					 * Ahora no tenemos que crear un documento, si no leer de un fichero.
					 * Eso se consigue con el m�todo parse
					 */
					documento = builder.parse(new File("GruposMusica.xml"));
					
				
					/*
					 * El m�todo getElementsByTagName lo que devuelve es todos aquellos elementos que
					 * se llamen como el String que se pasa por par�metro.
					 * En este caso, no queremos coger el nodo ra�z, si no todos los hijos.
					 */
					NodeList Musicos = documento.getElementsByTagName("Musico");
					for (int i = 0; i < Musicos.getLength(); i++) {
						Node Musico = Musicos.item(i);
						// Siempre que se lee de un DOM hay que comprobar que es de tipo ELEMENT_NODE
						// y que no es un espacio, un comentario, alg�n error humano...
						if(Musico.getNodeType() == Node.ELEMENT_NODE) {
						// El m�todo item(0) nos devolver� el nodo de la lista
						
						
						/*
						 * Como tenemos guardado un objeto de tipo Node, lo podemos especificar
						 * creando una variable de tipo Element
						 */
						
						
						Element elemento = (Element) Musico;

						
						System.out.print(elemento.getElementsByTagName("nombre").item(0).getTextContent());
						System.out.print(" ");
						System.out.print(elemento.getElementsByTagName("año_formacion").item(0).getTextContent());
						System.out.print(" ");
						System.out.print(elemento.getElementsByTagName("genero").item(0).getTextContent());
						System.out.println();
						/*
						 * Para obtener los atributos, se tendr�a que ejecutar algo as�
						 *  elemento.getAttribute("Discografica");
						 */
						}
					}
					
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (SAXException saxe) {
					saxe.printStackTrace();
				}
			}
			
			public static void main(String args[]) {
				
				ArrayList<Musico> listaMusicos = null;
				
				Musico Musico1 = new Musico("The Wonder Years", 2005,"Punk-Pop");
				Musico Musico2 = new Musico("La Polla Records", 1980, "Punk");
				Musico Musico3 = new Musico("Phoebe Bridgers", 2012, "Indie-folk");
				
				listaMusicos = new ArrayList<Musico>();
				listaMusicos.add(Musico1);
				listaMusicos.add(Musico2);
				listaMusicos.add(Musico3);
				
				MusicoXML principal = new MusicoXML();
				principal.escribirXML(listaMusicos);
				principal.leerFicheroXML();
			}
	}


