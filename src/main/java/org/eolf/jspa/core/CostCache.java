package org.eolf.jspa.core;

import java.util.HashMap;
import java.util.Map;

public class CostCache {
  private final Map<String, Integer> jarMethodCosts = new HashMap<>();

  public void put(String methodSig, int cost) {
    jarMethodCosts.put(methodSig, cost);
  }

  public int get(String methodSig) {
    return jarMethodCosts.getOrDefault(methodSig, CostModel.METHOD_CALL);
  }
}
