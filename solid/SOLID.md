# SOLID Principles

-> Elegant and Robust Software  
- Solid principles are all interwined and interdependent
- Solid principles are most effective when whey are combined together
- - Is it important to get a wholesome view of all the SOLID principles
"Software components should be open for extension, but closed for modification"     
That is
- Close for modification: new features getting added to the software component, should NOT have to modify existing code
- Open For Extension: a software component should be extendable to add a new feature or add a new behavior to it.

"The only thing that is in constant change"     
Software is never dormant. It always keeps changing

## 5 Rules     

### Single Responsability Principle(SRP)    

- [Java Hands-on](link)
  
"Every software component should have one and only one responsability"      
OO: class, method, module of Java for example

Canivete suico vs Canivete unico

```Java
public class Square {
    int side = 5;

    public int calculateArea(){
        return side * side;
    }

    public int calculatePerimeter(){
        return side * 4;
    }

    public void draw() {
        if (highResolutionMonitor){
            // Render a high resolution image of square
        } else {
            // Render a normal image of square

        }
    }

    public void rotate(int degree){
        // Rotate the image of square clockwise 
        // to the required degree and re-render
    }
}

```

#### Cohesion and Coupling

"`Cohesion` is the degree to which the various parts of a software component are related"

Increase Cohesion

```Java
public class Square {
    int side = 5;

    public int calculateArea(){
        return side * side;
    }

    public int calculatePerimeter(){
        return side * 4;
    }
}

public class SquareUI {

    public void draw() {
        if (highResolutionMonitor){
            // Render a high resolution image of square
        } else {
            // Render a normal image of square

        }
    }

    public void rotate(int degree){
        // Rotate the image of square clockwise 
        // to the required degree and re-render
    }
}
```
`Note: higher cohesion helps attain better adherence to the SRP`        

"`Coupling` is defined as the level of interdependency between various software components" 

```Java
public class Student {
    private String studentId;
    private Date studentDOB;
    private String address;

    public void save() {
        String objectStr = MyUtils.serializeIntoAString(this);
        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "password");
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO STUDENT VALUES("+ objectStr + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    ...
}

```
[Increase Coupling]

```Java
public class Student {
    private String studentId;
    private Date studentDOB;
    private String address;

    public void save() {
        new StudentRepository().save(this);
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    ...
}

public class StudentRepository {
    public void save(Student student) {
        String objectStr = MyUtils.serializeIntoAString(student);
        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "password");
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO STUDENT VALUES("+ objectStr + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
`Note: loose coupling helps attain better adherence to the SRP`        

> "Every software component should have one and only one REASON TO CHANGE"      
> Software is never dormant. It always keeps changing

- A change in the student id format # student profile
- A change in the student name format # student profile
- A change in the database backend
  
  Increase Changes, increase Bugs, retesting software


`Conclusion: Following SRP can lead to considerable software maintenance costs`      


### Open-Closed Principle(OCP) 

- [Java Hands-on](link)
- imagem 


Note: things constant in Base classe that extends, and extensions methods       

"Every software component should be closed for modification, but open for extension"      

Nintendo Wii Console, pode ter controles complementares, p.e volante(pplug and play). Extensoes.

Pros:
- Easy of adding new features
- More easy to Test pieces
- Leads to minimal cost of developing and testing software
- OCP often requires decoupling, which, in turn, automatically follows the SRP

Caution:
- Do not follow the open Closed Principle blindly
- You will end up with huge number of classes that can complicate your overall desigin
- Make a subjective, rather an objective decision.


Exemple:
Create a Interface to implements classes that has the same method and are use in another main class, that is when we would need to create a new feature it is simple new class that implements interface.

`Conclusion: OCP and SRP can work together for better desing`


### Liskov Substitution Principle(LSP)

- [Java Hands-on](link)

> Objects should be replaceable with their subtypes without affecting the correctness of the program

The 'Is-A' way of thinking
Fox is A Car
Ostrich is-a Bird

```Java
public class Bird {
  public void fly() {
    //Fly 
  }
}

public class Ostrich extends Bird {

  @Override
  public void fly() {
    throw new RunTimeException();
  }
}
```
->Incorrect in this case with LSP

Solutions:
1. Break the hierarchy of it fails the substitution test.
2. Tell, Don't Ask. 


### Interface Segregation Principle (ISP)

- [Java Hands-on](link)

> No client should be forced to depend on methods it doesnt use


Exemple:

Interface IMultifunction with methods: scan, print, fax, internetFax, scanPhoto   
That interface implement a MasterXerox that has all these method    
That interface implement a Printer that has only some methods   
That interface implement a SimplePrinter that has only 2 methods



-To Resolve:
  Split interface in 3 interface
  1. implement all 3 interface
  2. implement 2 interface
  3. implement only one interface


- Techniques To indentify Violations of ISP:    
1. Fat Interfaces - so much methods in one interface    
2. Interfaces with low cohesion   
3. Empty method implementations   

This principle relation with Single Responsability Principle

> SOLID principles complement each other, and work together in unison, to achieve the common purpose of well-designed software


### Dependency Injection Principle (DIP)

- [Java Hands-on](link)

> High-level modules should not depend on low-level modules. Both should depend on abstractions.
> Abstractions should not depend on details. Details should depend on abstractions.




## References

- [Free Code SOLID](https://www-freecodecamp-org.cdn.ampproject.org/c/s/www.freecodecamp.org/news/solid-principles-explained-in-plain-english/amp/)    