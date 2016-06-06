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
            "<Court>" +
            "<id>1</id>" +
            "<name>Plaine</name>" +
            "<fkTournament>1</fkTournament>" +
            "</Court>" +
            "<Court>" +
            "<id>2</id>" +
            "<name>Montagne</name>" +
            "<fkTournament>1</fkTournament>" +
            "</Court>" +
            "<Court>" +
            "<id>3</id>" +
            "<name>Fenêtre</name>" +
            "<fkTournament>2</fkTournament>" +
            "</Court>" +
            "<Court>" +
            "<id>4</id>" +
            "<name>Gradins</name>" +
            "<fkTournament>2</fkTournament>" +
            "</Court>" +
            "</Courts>";
    private int id;
    private String name;
    private int fkTournament;

    private NodeList courts; // Parsed XML

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
            Document document = builder.parse(new InputSource(new StringReader(sourceFile)));
            Element racine = document.getDocumentElement();
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
        Integer foundId=0;
        Integer foundFkTournament=0;
        String foundName="";

        for (int n=0; n<courts.getLength(); n++)
        {
            Node subnode = courts.item(n);
            if (subnode.getNodeType() == Node.ELEMENT_NODE)
            {
                NodeList attributes = subnode.getChildNodes();
                for (int a=0; a<attributes.getLength(); a++)
                {
                    Node attr = attributes.item(a);
                    if (attr.getNodeType() == Node.ELEMENT_NODE)
                    {
                        switch (attr.getNodeName())
                        {
                            case "id": foundId=Integer.parseInt(attr.getFirstChild().getNodeValue()); break;
                            case "name": foundName = attr.getFirstChild().getNodeValue(); break;
                            case "fkTournament": foundFkTournament = Integer.parseInt(attr.getFirstChild().getNodeValue()); break;
                        }
                    }
                }
                if (foundId == id)
                {
                    this.id = foundId;
                    this.name=foundName;
                    this.fkTournament=foundFkTournament;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean load_index(int index)
    {
        Integer foundId=0;
        Integer foundFkTournament=0;
        String foundName="";

        if (index < courts.getLength())
        {
            NodeList attributes = courts.item(index).getChildNodes();
            for (int a=0; a<attributes.getLength(); a++)
            {
                Node attr = attributes.item(a);
                if (attr.getNodeType() == Node.ELEMENT_NODE)
                {
                    switch (attr.getNodeName())
                    {
                        case "id": foundId=Integer.parseInt(attr.getFirstChild().getNodeValue()); break;
                        case "name": foundName = attr.getFirstChild().getNodeValue(); break;
                        case "fkTournament": foundFkTournament = Integer.parseInt(attr.getFirstChild().getNodeValue()); break;
                    }
                }
            }
            this.id = foundId;
            this.name=foundName;
            this.fkTournament=foundFkTournament;
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
