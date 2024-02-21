//Benjamin Powell
// 2/21/24

import static utils.Utilities.writeFile;


import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;


public class gen9 {
    public static void main(String [] args){

        //boiler plate code for class writer and methodvisitor

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program9", null , "java/lang/Object", null);
    
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
            
            //this code take a input from the user then accumulates it in a while loop

         

            mv.visitCode();
            Label inttest1 = new Label();//creating the labels for later
            Label inttest2 = new Label();
            mv.visitTypeInsn(Opcodes.NEW , "java/util/Scanner"); // creating the scanner we will need
            mv.visitInsn(Opcodes.DUP); // Duplicating the scanner we just made
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;"); //prepare the user input from input stream
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false); //call the scaner to take values
            mv.visitVarInsn(Opcodes.ASTORE, 1); //we store the value from the scanner
            mv.visitIntInsn(Opcodes.BIPUSH, 6); //then i push a 6 onto the stack of amount of times we will loop we could of also used ldc i think but the decompiler wanted me to push instead so i pushed
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);// making sure its a int value
            mv.visitVarInsn(Opcodes.ASTORE, 2);//storing the value
            mv.visitInsn(Opcodes.ICONST_1); // creating a constant 1
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
            mv.visitVarInsn(Opcodes.ASTORE, 3);//storing the next value then loading the first value
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);// taking the next int put into the scanner
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
            mv.visitVarInsn(Opcodes.ASTORE, 4);
            mv.visitLabel(inttest2); // we jump here to continue the loop
            mv.visitVarInsn(Opcodes.ALOAD, 2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitJumpInsn(Opcodes.IF_ICMPLE , inttest1); //if the value 6 is fully subtracted we then move to the label at the end to end the loop
            mv.visitVarInsn(Opcodes.ALOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false); 
            mv.visitVarInsn(Opcodes.ALOAD, 4); //same things again taking the values and loading them for addition operation
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            mv.visitInsn(Opcodes.IADD); // we do the addition operation 
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false); 
            mv.visitVarInsn(Opcodes.ASTORE, 3);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/Object;)V", false);
            mv.visitVarInsn(Opcodes.ALOAD, 2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitInsn(Opcodes.ISUB); // we subtract 1 from the 6 so its lowered every time we go though the loop
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
            mv.visitVarInsn(Opcodes.ASTORE, 2); 
            mv.visitJumpInsn(Opcodes.GOTO, inttest2);// we then go back to the start of the loop
            


            
     

            mv.visitLabel(inttest1);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(3,3);
            mv.visitEnd();

         

        }//end of methodvisitor main 

        //boiler plate ending code to write it to the program file

        cw.visitEnd();

        byte[] b = cw.toByteArray();
    
        writeFile(b,"program9.class");

        System.out.println("testing this has compiled");


    }//end of main 
}//end of gen7
