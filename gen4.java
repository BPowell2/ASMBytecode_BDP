//Benjamin Powell
// 2/21/24

import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen4 {
    public static void main(String [] args){

        //boiler plate code for class writer and methodvisitor 

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program4", null , "java/lang/Object", null);
    
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
            //int
            //
            mv.visitCode();
            Label inttest1 = new Label();//creating the labels we will need later for if statements 
            Label inttest2 = new Label();
            mv.visitLdcInsn((Integer)20);
            mv.visitVarInsn(Opcodes.ISTORE, 1); //generic just creating ints then store them then loading them up
            mv.visitLdcInsn((Integer)10);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitJumpInsn(Opcodes.IF_ICMPLE , inttest1); //now that the ints we created are loaded we compare them and if it is less than we send to the inttest1 labelvisit
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);  // here we load the output stream and print out the result if the last cmp line wasnt true
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, inttest2); // tells us to go to the end of the program since the next part is what needs toe be done if it was less than
            mv.visitLabel(inttest1); // we visit the lines after this if it was less than eariler 
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 2); // loading the 2nd number and printing it out like always
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

           
           
 


        

            mv.visitLabel(inttest2);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(3,3);
            mv.visitEnd();

        }//end of methodvisitor main

        //boiler plate ending then wirting to program file

        cw.visitEnd();

        byte[] b = cw.toByteArray();
    
        writeFile(b,"program4.class");
    
    
            System.out.println("testing this has compiled");

    }//end of main
    
}//end of gen4
