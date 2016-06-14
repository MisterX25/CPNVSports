package Entities;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Xavier on 29.05.16.
 */
public class Court
{
    private int id;
    private String name;
    private int fkTournament;

    public void setId(int id) { this.id = id; }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getFkTournament() {
        return fkTournament;
    }

    public void setFkTournament(int fkTournament) {
        this.fkTournament = fkTournament;
    }

    public String dump()
    {
        return name + "(" + id + ")";
    }
}
