
package com.mycompany.ca4;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Airline")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Airline.findAll", query = "SELECT a FROM Airline a"),
    @NamedQuery(name = "Airline.findByArilineID", query = "SELECT a FROM Airline a WHERE a.arilineID = :arilineID"),
    @NamedQuery(name = "Airline.findByName", query = "SELECT a FROM Airline a WHERE a.name = :name")
})
public class Airline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "arilineID")
    private Integer arilineID;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "airline")
    private Collection<Flight> flightCollection;

    public Airline()
    {
    }

    public Airline(Integer arilineID)
    {
        this.arilineID = arilineID;
    }

    public Integer getArilineID()
    {
        return arilineID;
    }

    public void setArilineID(Integer arilineID)
    {
        this.arilineID = arilineID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @XmlTransient
    public Collection<Flight> getFlightCollection()
    {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection)
    {
        this.flightCollection = flightCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (arilineID != null ? arilineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airline))
        {
            return false;
        }
        Airline other = (Airline) object;
        if ((this.arilineID == null && other.arilineID != null) || (this.arilineID != null && !this.arilineID.equals(other.arilineID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mycompany.ca4.Airline[ arilineID=" + arilineID + " ]";
    }

}
