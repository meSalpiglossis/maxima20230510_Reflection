import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectionExample {
    public static void main (String[] args) throws ClassNotFoundException {
        int modifiers;
        String DIVIDER = "========================================";

        //Example00: 3 ways to create an object of the class
        System.out.println(DIVIDER + " Example00 " + DIVIDER);
        //1 - By using Class.forname() method
        Class way1 = Class.forName("ReflectionExample");
        System.out.println(way1.getName());

        //2- By using getClass() method
        ReflectionExample obj = new ReflectionExample();
        Class way2 = obj.getClass();

        //3- By using .class
        Class way3 = ReflectionExample.class;

        Class stringMetaClass = String.class;
        System.out.println(stringMetaClass.getName());

        Class stringSuperClassMeta = stringMetaClass.getSuperclass();
        System.out.println(stringSuperClassMeta.getName());


        //Example01: How to get Metadata of Class
        System.out.println(DIVIDER + "Example01 " + DIVIDER);
        // Create Class object for ClassExample01.class
        Class classExample01MC = ClassExample.class;

        // Print name of the class
        System.out.println("Name of the class is : " + classExample01MC.getName());

        // Print Super class name
        System.out.println("Name of the super class is : " + classExample01MC.getSuperclass().getName());

        // Get the list of implemented interfaces in the form of Class array using getInterfaces() method
        Class[] interfaceArray = classExample01MC.getInterfaces();

        // Print the implemented interfaces using foreach loop
        System.out.print("Implemented interfaces are : ");
        for (Class currentInterface : interfaceArray){
            System.out.println(currentInterface.getName() + " ");
        }
        System.out.println();

        //Get access modifiers using get Modifiers() method and toString() method of java.lang.reflect.Modifier class
        modifiers = classExample01MC.getModifiers();
        // Print the access modifiers
        System.out.println("Access modifiers of the class are : " + Modifier.toString(modifiers));


        //Example02: How to get Metadata of Field
        System.out.println(DIVIDER + "Example02 " + DIVIDER);
        // Create Class object for ClassExample.class
        ClassExample objClassExample02 = new ClassExample();
        Class classExample02MC = objClassExample02.getClass();

        // Get the metadata of all the fields of the class Guru99VariableMetaData
        Field[] fields = classExample02MC.getDeclaredFields();

        // Print name, datatype, access modifiers and values of the fields of the specified class
        for(Field field : fields){
            try {
                System.out.println("Variable name : " + field.getName());
                System.out.println("Datatype of the variable :" + field.getType());

                modifiers = field.getModifiers();
                System.out.println("Access Modifiers of the variable : " + Modifier.toString(modifiers));
                System.out.println("Value of the variable : " + field.get(objClassExample02));
            } catch(Exception ex){
                System.out.println("!!!!!!!!!!!!");
                System.out.println(ex.toString());
                System.out.println("!!!!!!!!!!!!");
            } finally {
                System.out.println(DIVIDER);
            }
        }


        //Example03: How to get Metadata of Method
        System.out.println(DIVIDER + "Example03 " + DIVIDER);
        // Create Class object for MetaData.class
        Class objClassExample03MT = ClassExample.class;

        // Get the metadata or information of all the methods of the class using getDeclaredMethods()
        Method[] methods = objClassExample03MT.getDeclaredMethods();

        for(Method method : methods) {
            // Print the method names
            System.out.println("Name of the method : " + method.getName());

            // Print return type of the methods
            System.out.println("Return type of the method : " + method.getReturnType());

            // Get the access modifier list and print
            int modifierList = method.getModifiers();
            System.out.println("Method access modifiers : " + Modifier.toString(modifierList));

            // Get and print parameters of the methods
            Class[] parametersClasses = method.getParameterTypes();
            System.out.print ("Method parameter types : ");
            for (Class currentClass : parametersClasses){
                System.out.println(currentClass.getName() + " ");
            }
            System.out.println();

            // Get and print exception thrown by the method
            Class[] exceptionsClasses = method.getExceptionTypes();
            System.out.println("Exception thrown by method :");
            for (Class currentClass : exceptionsClasses) {
                System.out.println (currentClass.getName() + " ");
            }
            System.out.println(DIVIDER);
        }


        //Example04: How to get Metadata of Constructors
        System.out.println(DIVIDER + "Example04 " + DIVIDER);
        // Create Class object
        Class objClassExample04MT = ClassExample.class;

        // Get all the constructor information in the Constructor array
        Constructor[] constructors = objClassExample04MT.getConstructors();
        for (Constructor constructor : constructors) {
            // Print all name of each constructor
            System.out.println("Constructor name : " + constructor.getName());

            //Get and print access modifiers of each constructor
            modifiers = constructor.getModifiers();
            System.out.println("Constructor modifier : " + Modifier.toString(modifiers));

            // Get and print parameter types
            Class[] parametersClasses = constructor.getParameterTypes();
            System.out.print ("Constructor parameter types :");
            for (Class currentClass : parametersClasses) {
                System.out.println(currentClass.getName() + " ");
            }
            System.out.println();

            // Get and print exception thrown by constructors
            Class[] exceptinsClasses = constructor.getExceptionTypes();
            System.out.println("Exception thrown by constructors :");
            for (Class class1 : exceptinsClasses) {
                System.out.println(class1.getName() +" ");
            }
            System.out.println(DIVIDER);
        }
    }
}
