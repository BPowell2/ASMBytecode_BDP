//Benjamin Powell
// 2/21/24

//generic imports 

import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen5 {
    
    public static void main(String [] args){

        //generic boiler plate code for classwriter and methodvisitor for all programs

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program5", null , "java/lang/Object", null);
    
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
            //string variables
            mv.visitCode();
            mv.visitLdcInsn((String)"hello world");// here we create a string
            mv.visitVarInsn(Opcodes.ASTORE, 1);// then we store the string in ASTORE
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");//we then prepare the printstream
            mv.visitVarInsn(Opcodes.ALOAD, 1); // load the before made string
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); //finally print out the string


            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();

        }//end of main methodvisitor
        
        //boiler plate code for ending then creating program file 

        cw.visitEnd();

        byte[] b = cw.toByteArray();
    
        writeFile(b,"program5.class");
    
    
            System.out.println("testing this has compiled");

    }//end of main


}//end of gen5
