java-persistence-tutorial
=========================

## Overview
This is a project that was created as a tutorial of JPA 2.1. Dependent libraries are as follows.

* JPA 2.1
* HIbernate EntityManager 4.3.2.Final
* H2Database 1.3.175
* Spring Framework 4.0.0.RELEASE

## Domain Model
Model is the ordering system very simple.

![ER Diagram](https://raw.github.com/satoshiyamamoto/java-persistence-tutorial/master/docs/erd.png)


### How to run

    $ mvn package
    $ java -cp target/dependency/*:target/classes name.yamamoto.satoshi.persistence.Main

    14:24:17.848 [main] INFO  name.yamamoto.satoshi.persistence.Main -
    -----------------------------------------------------
    ID          : 1
    Category    : Mac / Macbook
    Tags        : [Retina, Laptop]
    Product     : MacBook Pro 13inch Retina Display
    Description : すべてのピクセルに、さらなるパワーを
    Price       : 200.00
    -----------------------------------------------------
    14:24:17.849 [main] INFO  name.yamamoto.satoshi.persistence.Main -
    -----------------------------------------------------
    ID          : 2
    Category    : iPhone
    Tags        : [Retina, Tablet]
    Product     : iPhone 5s 64G
    Description : 進み続けるもの
    Price       : 50.00
    -----------------------------------------------------
    
    14:24:17.867 [main] INFO  name.yamamoto.satoshi.persistence.Main -
    -----------------------------------------------------
    Order No          : 1
    Puchase orderdate : 2014-03-03 14:24:17.543
    
      1: MacBook Pro 13inch Retina Display    1 x 200.00
      2: iPhone 5s 64G                        2 x 100.00
    
    Total amount      : 400.0
    -----------------------------------------------------
