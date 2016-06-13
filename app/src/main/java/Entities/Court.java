package Entities;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Xavier on 29.05.16.
 */
public class Court implements XMLoadable, Dumpable
{
    private final String sourceFile = 
            "<Courts>" +
            "<Court id=\"1\">" +
            "<name>Plaine</name>" +
            "<fkTournament>1</fkTournament>" +
            "</Court>" +
            "<Court id=\"2\">" +
            "<name>Montagne</name>" +
            "<fkTournament>1</fkTournament>" +
            "</Court>" +
            "<Court id=\"3\">" +
            "<name>Fenêtre</name>" +
            "<fkTournament>2</fkTournament>" +
            "</Court>" +
            "<Court id=\"7\">" +
            "<name>Gradins</name>" +
            "<fkTournament>2</fkTournament>" +
            "</Court>" +
            "</Courts>";
    private int id;
    private String name;
    private int fkTournament;

    private NodeList courts; // Parsed XML
    private Element racine;
    private Document document;

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

    public Court()
    {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(sourceFile)));
            racine = document.getDocumentElement();
            courts = racine.getChildNodes();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean load_id(Integer id)
    {
        Element n = document.getElementById(String.valueOf(id));
        if (n != null)
        {
            this.id = id;
            this.name=n.getChildNodes().item(0).getFirstChild().getNodeValue();
            this.fkTournament = Integer.parseInt(n.getChildNodes().item(1).getFirstChild().getNodeValue());
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean load_index(int index)
    {
        if (index < courts.getLength())
        {
            Element n = (Element)courts.item(index);
            this.id = Integer.parseInt(n.getAttribute("id"));
            this.name=n.getChildNodes().item(0).getFirstChild().getNodeValue();
            this.fkTournament = Integer.parseInt(n.getChildNodes().item(1).getFirstChild().getNodeValue());
            return true;
        }
        else
            return false;
    }

    @Override
    public int numberOfCandidates()
    {
        return courts.getLength();
    }

    @Override
    public String dump() {
        return "Court "+id+": "+name+" (tournoi "+fkTournament+")";
    }
}
