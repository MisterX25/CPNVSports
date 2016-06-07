package Entities;

import android.content.Context;
import android.util.Log;

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
    private final String sourceFileName = "courts.xml";
    private DataSource ds = null;

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

    public Court(Context context)
    {
        ds = new DataSource(context,sourceFileName);
    }

    public void parseData()
    {
        if (!ds.isLoaded()) return;

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(ds.getFileContent())));
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
    public void refresh() {
        ds.reload();
    }

    @Override
    public String dump() {
        return "Court "+id+": "+name+" (tournoi "+fkTournament+")";
    }
}
