package org.eolf.jspa.core;

public class MethodCost {

  private final String methodSignature;
  private final int cost;

  public MethodCost(String methodSignature, int cost) {
    this.methodSignature = methodSignature;
    this.cost = cost;
  }

  public String getMethodSignature() {
    return methodSignature;
  }

  public int getCost() {
    return cost;
  }

  @Override
  public String toString() {
    return "MethodCost{" +
        "methodSignature='" + methodSignature + '\'' +
        ", cost=" + cost +
        '}';
  }
}
