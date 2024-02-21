//Benjamin Powell
// 2/21/24

//generic imports for all programs first for wiriting the program file and ASM
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen1 {

   

    public static void main(String[] args){
    //boiler plate for all programs creating the class writer for us to then use the program we write 
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program1", null , "java/lang/Object", null);

    {
        MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(1,1);
		mv.visitEnd();

    }//end of first methodvisitor outside of main
    
    {
        MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main" ,  "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
        mv.visitLdcInsn((Double)2.00); // creating a double with the value of 2.00 
        mv.visitVarInsn(Opcodes.DSTORE, 1); // storing the double onto the stack
        mv.visitLdcInsn((Double)10.00); // same as above
        mv.visitVarInsn(Opcodes.DSTORE, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 1);// we load both values from the stack ready to use them
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitInsn(Opcodes.DMUL);// we take both of the loaded values and multiply them
        mv.visitVarInsn(Opcodes.DSTORE, 5);// we store the result left into the stack
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); // we get the printstream method
        mv.visitVarInsn(Opcodes.DLOAD, 5); // we load the result of the multiplication
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false); // we then use the printstream to print the result
        
        //int 

        //we do the exact same as the first section but this time using int values so we pass them as a int
        //then make sure to store them with the proper store and load method for ints
        mv.visitLdcInsn((Integer)3);
        mv.visitVarInsn(Opcodes.ISTORE, 1);
        mv.visitLdcInsn((Integer)10);
        mv.visitVarInsn(Opcodes.ISTORE, 3);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitInsn(Opcodes.IMUL);
        mv.visitVarInsn(Opcodes.ISTORE, 5);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 5);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);


        //long time 
       //same thing again but this time we store long values then multiply them 
       //with correct use stores and operations for longs    
       mv.visitLdcInsn(23L);
       mv.visitVarInsn(Opcodes.LSTORE, 2);
       mv.visitLdcInsn(3L);
       mv.visitVarInsn(Opcodes.LSTORE, 4);
       mv.visitVarInsn(Opcodes.LLOAD, 2);
       mv.visitVarInsn(Opcodes.LLOAD, 4);
       mv.visitInsn(Opcodes.LMUL);
       mv.visitVarInsn(Opcodes.LSTORE, 6);
       mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
       mv.visitVarInsn(Opcodes.LLOAD, 6);
       mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
        
       //float 

       //exact same as the other 3 but with float values instead
       mv.visitLdcInsn((Float)5F);
       mv.visitVarInsn(Opcodes.FSTORE, 1);
       mv.visitLdcInsn((Float)15F);
       mv.visitVarInsn(Opcodes.FSTORE, 3);
       mv.visitVarInsn(Opcodes.FLOAD, 1);
       mv.visitVarInsn(Opcodes.FLOAD, 3);
       mv.visitInsn(Opcodes.FMUL);
       mv.visitVarInsn(Opcodes.FSTORE, 5);
       mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
       mv.visitVarInsn(Opcodes.FLOAD, 5);
       mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);


      //we use this to end the code we have ran above
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0,0);
        mv.visitEnd();




    }//end of main methodvisitor

    cw.visitEnd();
    //we set everything to a byte array
    byte[] b = cw.toByteArray();
    //then use this array to write the program 1 class we get the actual output from
    writeFile(b,"program1.class");

        //print statement for my sanity 
        System.out.println("testing this has compiled");

    }//end of main
}//end of gen1
