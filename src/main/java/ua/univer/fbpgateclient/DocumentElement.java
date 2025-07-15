package ua.univer.fbpgateclient;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@Getter
@XmlRootElement(name = "DocumentElement", namespace = "")
@XmlAccessorType (XmlAccessType.FIELD)
public class DocumentElement {
    @XmlElement(name="Portfolio", type=Paper.class)
    public List<Paper> papers = new ArrayList<>();
    
    @XmlElement(name="UnblockOrder", type=UnblockOrder.class)
    public List<UnblockOrder> unblockOrders = new ArrayList<>();

    @XmlElement(name="NewClient", type=NewClient.class)
    public List<NewClient> newClients = new ArrayList<>();

    @XmlElement(name="AddressOrder", type=AddressOrder.class)
    public List<AddressOrder> addressOrder = new ArrayList<>();

    @XmlElement(name="RepoOrder", type= RepoOrder.class)
    public List<RepoOrder> repoOrders = new ArrayList<>();


}
