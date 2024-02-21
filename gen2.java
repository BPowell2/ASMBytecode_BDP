//Benjamin Powell
// 2/21/24

//same boiler plate imports for all programs
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen2 {
    
    public static void main(String [] args){

        //same boiler plate code for setting up our class writer before the main method
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program2", null , "java/lang/Object", null);
    
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
        //double

        mv.visitCode();
        mv.visitLdcInsn((Double)20.00);// we add a double value
        mv.visitVarInsn(Opcodes.DSTORE, 1); // we then store the double value onto the stack
        mv.visitLdcInsn((Double)10.00); //same as before
        mv.visitVarInsn(Opcodes.DSTORE, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 1); // load them both to be used
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitInsn(Opcodes.DSUB); // use both values in subtraction
        mv.visitVarInsn(Opcodes.DSTORE, 5); // store the value from the subtraction
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); // get the print stream
        mv.visitVarInsn(Opcodes.DLOAD, 5);// load the stored value of the value gotten from subtraction
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false); // we then print said value out

        //int 

        //exact same as above but for ints
        mv.visitCode();
        mv.visitLdcInsn((Integer)25);
        mv.visitVarInsn(Opcodes.ISTORE, 1);
        mv.visitLdcInsn((Integer)10);
        mv.visitVarInsn(Opcodes.ISTORE, 3);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitInsn(Opcodes.ISUB);
        mv.visitVarInsn(Opcodes.ISTORE, 5);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 5);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        //long

        //exact same as above but for longs
        mv.visitCode();
        mv.visitLdcInsn((Long)25L);
        mv.visitVarInsn(Opcodes.LSTORE, 1);
        mv.visitLdcInsn((Long)10L);
        mv.visitVarInsn(Opcodes.LSTORE, 3);
        mv.visitVarInsn(Opcodes.LLOAD, 1);
        mv.visitVarInsn(Opcodes.LLOAD, 3);
        mv.visitInsn(Opcodes.LSUB);
        mv.visitVarInsn(Opcodes.LSTORE, 5);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.LLOAD, 5);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);


        //float 

        //exact same as above but for floats 
        mv.visitCode();
        mv.visitLdcInsn((Float)50F);
        mv.visitVarInsn(Opcodes.FSTORE, 1);
        mv.visitLdcInsn((Float)10F);
        mv.visitVarInsn(Opcodes.FSTORE, 3);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 3);
        mv.visitInsn(Opcodes.FSUB);
        mv.visitVarInsn(Opcodes.FSTORE, 5);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.FLOAD, 5);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0,0);
        mv.visitEnd();


    }//end of main method visitors 

    //generic boiler plate code for ending the programs then writing them to the program file
    cw.visitEnd();

    byte[] b = cw.toByteArray();

    writeFile(b,"program2.class");


        System.out.println("testing this has compiled");

        

    }//end of main

}//end of gen2
