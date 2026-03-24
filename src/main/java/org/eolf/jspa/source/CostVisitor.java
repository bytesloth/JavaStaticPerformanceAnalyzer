package org.eolf.jspa.source;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.eolf.jspa.core.CostModel;

public class CostVisitor extends VoidVisitorAdapter<Void> {
  private int cost = 0;

  @Override
  public void visit(AssignExpr n, Void arg) {
    cost += CostModel.ASSIGN;
    super.visit(n, arg);
  }

  @Override
  public void visit(BinaryExpr n, Void arg) {
    cost += CostModel.ARITHMETIC;
    super.visit(n, arg);
  }

  @Override
  public void visit(MethodCallExpr n, Void arg) {
    cost += CostModel.METHOD_CALL;
    super.visit(n, arg);
  }

  @Override
  public void visit(ForStmt n, Void arg) {
    int before = cost;
    super.visit(n.getBody(), arg); // visit the loop body
    int loopBody = cost - before;
    cost += loopBody * CostModel.LOOP_MULTIPLIER;
  }

  public int getCost() { return cost; }
}