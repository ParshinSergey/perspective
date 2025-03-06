package ua.univer.fbpgateclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "DocumentElement", namespace = "")
@XmlAccessorType (XmlAccessType.FIELD)
public class DocumentElement {
    @XmlElement(name="Portfolio", type=Paper.class)
    public List<Paper> papers = new ArrayList<>();
    
    @XmlElement(name="UnblockOrder", type=UnblockOrder.class)
    public List<UnblockOrder> unblockOrders = new ArrayList<>();

    @XmlElement(name="NewClient", type=NewClient.class)
    public List<NewClient> newClient = new ArrayList<>();


}
