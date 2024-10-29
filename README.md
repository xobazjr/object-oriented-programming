# object-oriented-programming

## Polymorphism

Example

```java
public class main{
    public static void main(String[] args){
        animal myanimal = new animal();
        animal mypig = new pig();
        animal mydog = new dog();

        myanimal.animalsound(); //output: The animal makes sound
        mypig.animalsound(); //output: The pig says: wee wee
        mydog.animalsound(); //output: The dog says: bow bow

        if(mypig instanceof dog){
            mypig = (animal) mydog; //casting
            mypig.animalsound();
        }else{
            System.out.println("Pig can't to be dog"); //output: Pig can't to be dog
        }

        if(mypig instanceof animal && mydog instanceof animal){
            System.out.println("Pig and dog is animal"); //output: Pig and dog is animal
        }else{
            System.out.println("Pig and dog isn't animal");
        }

        if(mypig instanceof animal){
            mypig = (animal) myanimal; //casting
            mypig.animalsound(); //output: The animal makes sound
        }
    }
}

class animal{
    void animalsound(){
        System.out.println("The animal makes sound");
    }
}

class pig extends animal{
    void animalsound(){
        System.out.println("The pig says: wee wee");
    }
}

class dog extends animal{
    void animalsound(){
        System.out.println("The dog says: bow bow");
    }
}
```

```bash
The animal makes sound
The pig says: wee wee
The dog says: bow bow
Pig can't to be dog
Pig and dog is animal
The animal makes sound
```

## Abstract

Example

```java
public class main{
    public static void main(String[] args){
        animal mypig = new pig();
        animal mydog = new dog();

        mypig.animalSound(); //output: The pig says: wee wee
        mydog.animalSound(); //output: The dog says: bow bow

        mypig = (animal) mydog;
        mypig.animalSound(); //output: The dog says: bow bow
    }
}

abstract class animal{
    public abstract void animalSound();
}

class pig extends animal{
    @Override
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }
}

class dog extends animal{
    @Override
    public void animalSound(){
        System.out.println("The dog says: bow bow");
    }
}
```

```bash
The pig says: wee wee
The dog says: bow bow
The dog says: bow bow
```

## Interface

Example

```java
public class main{
    public static void main(String[] args){
        human human_1 = new human();
        System.out.println(human_1.toString()); //output: super human
                                                //        can fly   
                                                //        super power
        
        if(human_1 instanceof man){
            System.out.println("That human is a man"); //output: That human is a man
        }
    }
}

abstract class super_human implements man{
    public String get_super_human(){
        return "super human";
    }
}

interface fly{
    public String get_fly();
}

interface super_power{
    public String get_super_power();
}

interface man{
    public String get_man();
}


class human extends super_human implements fly,super_power{
    @Override
    public String get_fly(){
        return "can fly";
    }

    @Override
    public String get_super_power(){
        return "super power";
    }

    @Override
    public String get_man() {
        return "man";
    }

    @Override
    public String toString(){
        return  get_super_human()+"\n"+
                get_fly()+"\n"+
                get_super_power();

    }
}
```

```bash
super human
can fly
super power
That human is a man
```
