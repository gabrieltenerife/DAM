import java.io.*;
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

public class Main {

    public static void main(String args[]) {

        ArrayList<Gato> gatos = new ArrayList<Gato>();


        leerfichero(gatos);
        escribirXML(gatos);
    }

    public static void leerfichero(ArrayList<Gato> gatos) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("src/ficheros/gatos.txt")));
            //Hasta aqui hemos abierto la puerta del archivo
            //Leemos en bucle
            String linea = br.readLine();
            while (linea != null) {

                //El metodo Split te permite separar el String segun el valor que desees
                String[] gatoPrtido = linea.split(" ");

                Gato gato = new Gato(gatoPrtido[0], Integer.parseInt(gatoPrtido[1]),gatoPrtido[2], Boolean.parseBoolean(gatoPrtido[3]));
                gatos.add(gato);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el fichero: " + e.getMessage());
                }
            }
        }
    }

    public static void escribirXML(ArrayList<Gato> gatos) {
        // Creamos el DocumentBuilderFactory, que es el objeto que crea objetos de clase DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            // Creamos un documentBuilder utilizando la factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Creamos nuestro �rbol DOM, en este caso vac�o
            DOMImplementation dom = builder.getDOMImplementation();

            documento = dom.createDocument(null, "Gatos", null);

            // Con getDocumentElement() accedemos al elemento ra�z
            Element raiz = documento.getDocumentElement();

            /*
             * En DOM vamos a trabajar con diversos elementos:
             * Element: Corresponde a cada elemento (marcas) del documento
             * Node: Corresponde a cualquier componente del documento, puede ser textual, un elemento, un atributo...
             * Text: Se recfiere al texto que hay dentro de cada elemento
             */
            Element nodoGatos = null, nodoNombre = null, nodoEdad = null, nodoRaza = null, nodoAlergia = null;
            Text texto = null;
					
				

					// Ahora, por cada Musico de nuestro arrayList que nos env�an por par�metro
					for (Gato gatin : gatos) {
					
						//Creamos un elemento Musico y lo a�adimos a la raiz
						nodoGatos = documento.createElement("Gatos");
						raiz.appendChild(nodoGatos);
						
						//Si qusieramos a�adir un ATRIBUTO, se har�a as� (es un ejemplo) :
						//nodoMusico.setAttribute("Discografica", "Hopeless Records");
						
						// Creamos un elemento nombre y lo a�adimos al elemento Musico
						nodoNombre = documento.createElement("nombre");
						nodoGatos.appendChild(nodoNombre);

						texto = documento.createTextNode(gatin.getNombre());
						nodoNombre.appendChild(texto);

                        //------------
                        nodoEdad = documento.createElement("Edad");
                        nodoGatos.appendChild(nodoEdad);

                        String edad = String.valueOf(gatin.getEdad());
                        texto = documento.createTextNode(edad);
                        nodoEdad.appendChild(texto);

                        //------------
                        nodoRaza = documento.createElement("Raza");
                        nodoGatos.appendChild(nodoRaza);

                        texto = documento.createTextNode(gatin.getRaza());
                        nodoGatos.appendChild(texto);

                        //------------
                        nodoAlergia = documento.createElement("Alergia");
                        nodoGatos.appendChild(nodoNombre);

                        if(gatin.isAlergias()){
                            texto = documento.createTextNode("Tiene alergia");
                            nodoAlergia.appendChild(texto);
                        }else{
                            texto = documento.createTextNode("No tiene alergias");
                            nodoAlergia.appendChild(texto);
                        }


					}


            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("Veterinaria.xml"));

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
                if (Musico.getNodeType() == Node.ELEMENT_NODE) {
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

}


