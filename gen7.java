//Benjamin Powell
// 2/21/24

//generic imports for this project

import static utils.Utilities.writeFile;


import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;


public class gen7 {
    public static void main(String [] args){

        //boiler plate creation of the classwriter and method visitor

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program7", null , "java/lang/Object", null);
    
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
            //int while loop
            mv.visitCode();
            Label inttest1 = new Label();//create labels
            Label inttest2 = new Label();
            mv.visitLdcInsn((Integer)10); // then pass the int that i will be subtracting from in the while loop
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitLabel(inttest2); //we visit here at the start of each loop using visitlabel
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.ICONST_1);// load the constant of one to compare to the value we first made
            mv.visitJumpInsn(Opcodes.IF_ICMPLE , inttest1); //if the value is less then we move to end the loop
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1); //if not we do boiler plate of the number and printing it out
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitInsn(Opcodes.ISUB); //after printing it out we subtract from it once so its not a inf loop
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitJumpInsn(Opcodes.GOTO, inttest2); // we go back to the top of the loop to continue untill we no longer meet requirements
    

            mv.visitLabel(inttest1);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(3,3);
            mv.visitEnd();

         

        }//end of methodvisitor main 

        //generic boilerplate ending code to write to program file
        
        cw.visitEnd();

        byte[] b = cw.toByteArray();
    
        writeFile(b,"program7.class");

        System.out.println("testing this has compiled");


    }//end of main 
}//end of gen7
