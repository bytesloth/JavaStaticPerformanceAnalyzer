package org.eolf.jspa.source;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.eolf.jspa.core.MethodCost;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class JavaSourceCostAnalyzer {

  private final JavaParser javaParser = new JavaParser();

  public MethodCost analyzeFile(Path filePath) throws IOException {
    Optional<CompilationUnit> cu = javaParser.parse(filePath).getResult();

    CostVisitor visitor = new CostVisitor();
    visitor.visit(cu.get(), null);

    return new MethodCost(filePath.toString(), visitor.getCost());
  }
}