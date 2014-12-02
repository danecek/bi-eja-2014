package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Customer;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-15T12:25:46")
@StaticMetamodel(CustomerGroup.class)
public class CustomerGroup_ { 

    public static volatile SingularAttribute<CustomerGroup, Long> id;
    public static volatile SingularAttribute<CustomerGroup, String> name;
    public static volatile CollectionAttribute<CustomerGroup, Customer> customers;

}