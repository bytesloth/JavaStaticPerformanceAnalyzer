package org.eolf.jspa;

import org.eolf.jspa.core.AnalyzerEngine;

import java.nio.file.Paths;


public class Main {
  public static void main(String[] args) throws Exception {
    AnalyzerEngine engine = new AnalyzerEngine();
    engine.analyzeProject(
        Paths.get("src/main/java"),
        Paths.get("lib")
    );
  }
}
