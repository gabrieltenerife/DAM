package org.example;

import org.example.DAO.DivisionDAO;
import org.example.DAO.MatchDAO;
import org.example.Model.Division;
import org.example.Model.Match;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Session session = Conexion.getConexion().openSession();

        //NO CABEN TODOS LOS RESULTADOS EN EL PRINT, IR COMENTANDO METODOS Y EJECUTANDOLOS 1 A 1

        //Obtener ids de partidos en españa
        ArrayList<Match> PartidosEspaña = (ArrayList<Match>) session.createQuery("from Match where division.country = 'Spain'").getResultList();
        for (Match partido : PartidosEspaña) {
            System.out.println(partido.getId());
        }
        System.out.println("<---------------------------------------------------------->");

        //Obtener partidos por goleada
        System.out.println("<---------------------------------------------------------->");
        System.out.println("PARTIDOS GANADOS POR GOLEADA");
        ArrayList<Match> PartidosGoleada = (ArrayList<Match>) session.createQuery("from Match where (fthg - ftag) >= 3 ").getResultList();
        for (Match partido : PartidosGoleada) {
            System.out.println(partido);
        }
        System.out.println("<---------------------------------------------------------->");


        //Maximo goles equipo visitante
        System.out.println("<---------------------------------------------------------->");
        System.out.println("MAXIMOS GOLES VISITANTE");
        ArrayList<Match> paliza = (ArrayList<Match>) session.createQuery("from Match order by ftag desc").getResultList();
        System.out.println(paliza.get(0).getFtag());
        System.out.println("<---------------------------------------------------------->");


        //Cuantas veces aparece el equipo local por temporada
        System.out.println("<---------------------------------------------------------->");
        System.out.println("APARICIONES DE EQUIPOS POR TEMPORADA");
        ArrayList<Object[]> columnas = (ArrayList<Object[]>) session.createQuery("SELECT homeTeam, season, COUNT(*) FROM Match GROUP BY homeTeam,season").getResultList();
        for (Object[] columna : columnas) {
            String HomeTeam = columna[0].toString();
            String Season = columna[1].toString();
            String Count = columna[2].toString();
            System.out.println("HomeTeam: " + HomeTeam + ", Season: " + Season + ", Count: " + Count);
        }
        System.out.println("<---------------------------------------------------------->");

        //Se marcan 5 goles como visitante o local
        System.out.println("<---------------------------------------------------------->");
        System.out.println("DIVISIONES EN LAS QUE SE HA MARCADO ALMENOS 5 GOLES");
        ArrayList<Division> divisionesmas5goles = (ArrayList<Division>) session.createQuery("from Division d join fetch d.matchs partidos where partidos.ftag > 5").getResultList();
        for (Division d : divisionesmas5goles) {
            System.out.println(d.getDivision());
        }
        System.out.println("<---------------------------------------------------------->");


        //Seleccionar liga y devolver partidos jugados
        System.out.println("<---------------------------------------------------------->");
        System.out.println("SELECCIONAR LIGA");
        System.out.println("Indica una division");
        String division = sc.nextLine();

        Query query = session.createQuery("from Match where division.name = :sustituir ");
        query.setParameter("sustituir", division);
        ArrayList<Match> partidosdivision = (ArrayList<Match>) query.list();
        for (Match m : partidosdivision) {
            if (m.getMatchDate().toString().compareTo("2010") > 1) {
                System.out.println(m.getMatchDate());
            }
        }
        System.out.println("<---------------------------------------------------------->");


        //Partidos Tenerife Zaragoza
        System.out.println("<---------------------------------------------------------->");
        System.out.println("PARTIDOS TENERIFE-ZARAGOZA");
        ArrayList<Match> TenerifeMejor = (ArrayList<Match>) session.createQuery("" +
                "from Match where (homeTeam = 'Tenerife' and awayTeam = 'Zaragoza')").getResultList();

        ArrayList<Match> ZaragozaPeor = (ArrayList<Match>) session.createQuery("" +
                "from Match where (homeTeam = 'Zaragoza' and awayTeam = 'Tenerife')").getResultList();

        int ganadostenerife = 0;
        int ganadoszaragoza = 0;

        for (Match m : TenerifeMejor) {
            System.out.println(m);
            if (m.getFthg() > m.getFtag()) {
                ganadostenerife++;
            }
        }

        for (Match m : ZaragozaPeor) {
            System.out.println(m);
            if (m.getFthg() > m.getFtag()) {
                ganadoszaragoza++;
            }
        }

        System.out.println("Total de partidos ganados por el Tenerife: " + ganadostenerife);
        System.out.println("Total de partidos ganados por el Zaragoza: " + ganadoszaragoza);

        System.out.println("<---------------------------------------------------------->");

        session.close();
    }
}