package org.eolf.jspa.core;

import org.eolf.jspa.source.JavaSourceCostAnalyzer;
import org.eolf.jspa.bytecode.BytecodeCostAnalyzer;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.jar.JarFile;

public class AnalyzerEngine {

  private final JavaSourceCostAnalyzer sourceAnalyzer   = new JavaSourceCostAnalyzer();
  private final BytecodeCostAnalyzer   bytecodeAnalyzer = new BytecodeCostAnalyzer();
  private final CostCache              cache            = new CostCache();

  public void analyzeProject(Path srcDir, Path libDir) throws Exception {
    // 1. Analyze all JARs first
    Files.walk(libDir)
        .filter(p -> p.toString().endsWith(".jar"))
        .forEach(this::analyzeJar);

    // 2. Analyze source files
    Files.walk(srcDir)
        .filter(p -> p.toString().endsWith(".java"))
        .forEach(f -> {
          try {
            MethodCost mc = sourceAnalyzer.analyzeFile(f);
            System.out.println("Source cost: " + mc);
          } catch (Exception e) {
            e.printStackTrace();
          }
        });
  }

  private void analyzeJar(Path jarPath) {
    try (JarFile jarFile = new JarFile(jarPath.toFile())) {
      jarFile.stream()
          .filter(e -> e.getName().endsWith(".class"))
          .forEach(e -> {
            try (InputStream in = jarFile.getInputStream(e)) {
              MethodCost mc = bytecodeAnalyzer.analyzeClass(in);
              cache.put(e.getName(), mc.getCost());
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
