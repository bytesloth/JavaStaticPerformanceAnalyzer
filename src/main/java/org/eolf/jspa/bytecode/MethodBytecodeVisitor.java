package org.eolf.jspa.bytecode;

import org.eolf.jspa.core.CostModel;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodBytecodeVisitor extends MethodVisitor {
  private int cost = 0;

  public MethodBytecodeVisitor() {
    super(Opcodes.ASM9);
  }

  @Override
  public void visitInsn(int opcode) {
    switch (opcode) {
    case Opcodes.IADD:
    case Opcodes.ISUB:
    case Opcodes.IMUL:
      cost += CostModel.ARITHMETIC;
      break;
    case Opcodes.NEW:
      cost += CostModel.OBJECT_ALLOC;
      break;
    default:
      cost += 1;
    }
  }

  public int getCost() { return cost; }
}
