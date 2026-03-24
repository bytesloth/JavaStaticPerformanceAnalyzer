package org.eolf.jspa.bytecode;

import org.eolf.jspa.core.MethodCost;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BytecodeCostAnalyzer {

  public MethodCost analyzeClass(InputStream classBytes) throws IOException {
    ClassReader reader = new ClassReader(classBytes);
    List<MethodCost> results = new ArrayList<>();

    reader.accept(new ClassVisitor(Opcodes.ASM9) {
      @Override
      public MethodVisitor visitMethod(int access, String name, String desc,
          String signature, String[] exceptions) {
        return new MethodBytecodeVisitor() {
          @Override
          public void visitEnd() {
            results.add(new MethodCost(name, getCost()));
          }
        };
      }
    }, 0);

    return results.get(0);
  }
}
