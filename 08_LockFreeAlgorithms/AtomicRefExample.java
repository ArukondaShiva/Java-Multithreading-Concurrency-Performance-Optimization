import java.util.concurrent.atomic.AtomicReference;

public class AtomicRefExample {
    
    public static void main(String[] args) {
        
        String oldName = "OldName";
        String newName = "newName";

        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);

        if(atomicReference.compareAndSet(oldName, newName)){
            System.out.println("New Value is "+atomicReference.get());
        }else{
            System.out.println("Nothing happened");
        }

    }

}
