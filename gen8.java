//Benjamin Powell
// 2/21/24

//IMPORTANT 
// this is the exact same code as in gen4 since it was already a if then else statement so it should be the exact same

import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;


public class gen8 {
    public static void main(String [] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program8", null , "java/lang/Object", null);
    
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
            mv.visitCode();
            Label inttest1 = new Label();
            Label inttest2 = new Label();
            mv.visitLdcInsn((Integer)20);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitLdcInsn((Integer)10);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitJumpInsn(Opcodes.IF_ICMPLE , inttest1); 
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, inttest2);
            mv.visitLabel(inttest1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            mv.visitLabel(inttest2);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(3,3);
            mv.visitEnd();

         

        }//end of methodvisitor main 
        cw.visitEnd();

        byte[] b = cw.toByteArray();
    
        writeFile(b,"program8.class");

        System.out.println("testing this has compiled");


    }//end of main 
}//end of gen8 
