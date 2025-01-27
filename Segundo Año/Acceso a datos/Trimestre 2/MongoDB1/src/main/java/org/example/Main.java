package org.example;


import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

import static java.util.Arrays.asList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Conectar a mongo
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        //Conectar a la db
        MongoDatabase db = client.getDatabase("Dam");

        /*
        //Accedemos a la coleccion
        MongoCollection<Document> collection = db.getCollection("Fiestas");

        //Añadir un documento
        Document fiesta = new Document();
        fiesta.append("Dj", "Kiko Rivera");
        fiesta.append("Precio", 200);
        fiesta.append("Fecha", new Date());
        fiesta.append("Menores", false);

        Document Lugar = new Document();
        Lugar.append("Direccion", "Chani street");
        Lugar.append("Alquiler", "25 totis");
        Lugar.append("Fecha", new Date());

        fiesta.append("Lugar", Lugar);

        Document invitado = new Document();
        invitado.append("Nombre", "El bolichoso");
        invitado.append("olor", "regular");

        Document invitado2 = new Document();
        invitado2.append("Nombre", "Juan Alimaña");
        invitado2.append("olor", "malo");

        ArrayList <Document> listaInvitados = new ArrayList<Document>();
        listaInvitados.add(invitado);
        listaInvitados.add(invitado2);

        fiesta.append("Invitados", listaInvitados);

        collection.insertOne(fiesta);

        //---------------------------------------------------------------------

        //Consultas
        collection.find(Filters.lt("Dj", "Kiko Rivera"));

        //Podemos guardar una consulta
        Bson filtro = Filters.lt("Dj", "Kiko Rivera");
        collection.find(filtro);
         */


        //EJERCICIO CONSULTAS
        MongoCollection<Document> Consultas = db.getCollection("Disney");

        //Consultas.find(Filters.lt("Release date (datetime)", "1950")).forEach(j -> System.out.println(j.toJson()));
        //Consultas.find(Filters.gt("Running time", "90")).forEach(j -> System.out.println(j.toJson()));
        //Consultas.find(Filters.gt("imdb", 8.0)).forEach(j -> System.out.println(j.toJson()));

        /*
        Consultas.find(Filters.or(
                Filters.eq("Language", "English"),
                Filters.eq("Language", "Spanish")
                )).forEach(j-> System.out.println(j.toJson()));
         */

        /*
        Consultas.find(Filters.and(
                Filters.eq("Production company","Walt Disney Productions"),
                Filters.gt("imdb",7.5)
        )).sort(Sorts.ascending("imdb")).forEach(f -> System.out.println(f.toJson()));
         */

        /*
        Consultas.find(Filters.and(
                Filters.gt("Release date (datetime)","1999"),
                Filters.lt("Release date (datetime)","2011"),
                Filters.gt("metascore","90")
        )).sort(Sorts.ascending("imdb")).forEach(f -> System.out.println(f.toJson()));
         */

        //Consultas.find(Filters.exists("Budget", false)).forEach(j -> System.out.println(j.toJson()));


        //----------------------------------------------
        //CONSULTAR DENTRO DE UN ARRAY

        /*
        //PARA BUSCAR VARIOS EN UN ARRAY
        Consultas.find(Filters.all("Language", asList("English","Spanish"))).forEach(t-> System.out.println(t.toJson()));
         */
        MongoCollection<Document> ConsultasArray = db.getCollection("students");

        /*
         */

        /*
        ConsultasArray.find(Filters.elemMatch("scores", Filters.lt("score",50))).forEach(t-> System.out.println(t.toJson()));
         */

        /*
        ConsultasArray.find(Filters.regex("name","^a")).forEach(t-> System.out.println(t.toJson()));
         */

        //______________________________________
        //Tuberias

        /*
        //Campos mostramos campos que queramos
        for(Document document : Consultas.find().projection(Projections.include("title"))){
            System.out.println(document.toJson());
        }
         */

        /*
        //Esto para agrupar todos los datos en imdb y sacamos el mumero max y min
        Bson agrupacion = Aggregates.group(null,
                Accumulators.max("Maximo historico","$imdb"),
                Accumulators.min("Peor pelicula", "$imdb"));

        Consultas.aggregate(asList(agrupacion)).forEach(f -> System.out.println(f.toJson()));
         */


        /*
        //Hacemos varias operaciones (equivalencias a sql en el pdf) y las ponemos en una tuberia
        Bson filtrado = Aggregates.match(
                Filters.gt("imdb",5.0)); // WHERE

        Bson proyeccion = Aggregates.project(Projections.fields(asList(Projections.include("imdb","title")))); // SELECT title, imdb

        Bson ordenacion = Aggregates.sort(Sorts.descending("imdb"));

        Bson limite = Aggregates.limit(5);

        Consultas.aggregate(asList(proyeccion,filtrado,ordenacion,limite)).forEach(f -> System.out.println(f.toJson()));
         */

        //CONSULTAS --------------------------------------------

        MongoCollection<Document> tnf = db.getCollection("TNF");

        /*
        Bson minmaxav = Aggregates.group(null,
                Accumulators.max("Maximo habitantes","$TOTAL"),
                Accumulators.min("Minimo de habitantes","$TOTAL"),
                Accumulators.avg("Media","$TOTAL")
        );

        tnf.aggregate(asList(minmaxav)).forEach(f-> System.out.println(f.toJson()));
         */

        /*
        Bson select = Aggregates.project(Projections.fields(Projections.include("DISTRITO","TOTAL")));
        Bson poblacionporbarrio = Aggregates.group("$DISTRITO",
                Accumulators.sum("tot_dis","$TOTAL"));

        // SELECT X, SUM(TOTAL) as tot_dis
        // FROM TABLA
        // GROUP BY X

        tnf.aggregate(List.of(select,poblacionporbarrio)).forEach(f-> System.out.println(f.toJson()));
         */


        Bson match = Aggregates.match(Filters.eq("OFRA - COSTA SUR"));
        Bson maxmujeres = Aggregates.group(null, Accumulators.max("maxMujeres","$MUJERES"));
        tnf.aggregate(asList(match,maxmujeres)).forEach(f-> System.out.println(f.toJson()));














        client.close();

    }
}