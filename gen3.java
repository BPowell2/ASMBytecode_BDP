//Benjamin Powell
// 2/21/24

//generic boiler plate imports for all programs 

import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;
public class gen3 {
    public static void main(String[] args){

        //boiler plate code for classwriter and method visitor

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program3", null , "java/lang/Object", null);
    
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

            //same as the last 2 programs but this time we divide instead of multiply or subtract
            mv.visitCode();
            mv.visitLdcInsn((Double)20.00);
            mv.visitVarInsn(Opcodes.DSTORE, 1);
            mv.visitLdcInsn((Double)10.00);
            mv.visitVarInsn(Opcodes.DSTORE, 3);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitVarInsn(Opcodes.DLOAD, 3);
            mv.visitInsn(Opcodes.DDIV);
            mv.visitVarInsn(Opcodes.DSTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);


            //int

            //same as the last programs but for ints
            mv.visitCode();
            mv.visitLdcInsn((Integer)50);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitLdcInsn((Integer)2);
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitInsn(Opcodes.IDIV);
            mv.visitVarInsn(Opcodes.ISTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            //long 
           
            //same as the last programs but for longs
            mv.visitCode();
            mv.visitLdcInsn((Long)40L);
            mv.visitVarInsn(Opcodes.LSTORE, 1);
            mv.visitLdcInsn((Long)4L);
            mv.visitVarInsn(Opcodes.LSTORE, 3);
            mv.visitVarInsn(Opcodes.LLOAD, 1);
            mv.visitVarInsn(Opcodes.LLOAD, 3);
            mv.visitInsn(Opcodes.LDIV);
            mv.visitVarInsn(Opcodes.LSTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            //float 

            //same as for the last programs but for floats
            mv.visitCode();
            mv.visitLdcInsn((Float)10F);
            mv.visitVarInsn(Opcodes.FSTORE, 1);
            mv.visitLdcInsn((Float)10F);
            mv.visitVarInsn(Opcodes.FSTORE, 3);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitVarInsn(Opcodes.FLOAD, 3);
            mv.visitInsn(Opcodes.FDIV);
            mv.visitVarInsn(Opcodes.FSTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);



            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();

        }//end of main method ender 


        //boiler plate ending code to write what we did to program file
        cw.visitEnd();

        byte[] b = cw.toByteArray();
    
        writeFile(b,"program3.class");
    
    
            System.out.println("testing this has compiled");
    

    }//end of main
}//end of gen3
