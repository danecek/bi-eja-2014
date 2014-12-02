package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CustomerGroup;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-06T12:00:21")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, Integer> age;
    public static volatile SingularAttribute<Customer, CustomerGroup> group;
    public static volatile SingularAttribute<Customer, Integer> version;

}