package org.eolf.jspa.core;

public class OperationWeights {

  // ===== Primitive operations =====
  public static final int ASSIGNMENT = 1;
  public static final int ARITHMETIC = 2;
  public static final int COMPARISON = 1;
  public static final int BOOLEAN_OP = 1;

  // ===== Variable & field access =====
  public static final int LOCAL_VAR_ACCESS = 1;
  public static final int FIELD_READ       = 2;
  public static final int FIELD_WRITE      = 3;

  // ===== Control flow =====
  public static final int IF_STATEMENT     = 2;
  public static final int ELSE_STATEMENT   = 1;
  public static final int SWITCH_STATEMENT = 5;
  public static final int LOOP_OVERHEAD    = 3;

  // ===== Multipliers =====
  public static final int LOOP_MULTIPLIER = 10;

  // ===== Method calls =====
  public static final int METHOD_CALL          = 5;
  public static final int STATIC_METHOD_CALL   = 3;
  public static final int EXTERNAL_METHOD_CALL = 7;

  // ===== Object / arrays =====
  public static final int NEW_OBJECT   = 10;
  public static final int ARRAY_ACCESS = 2;
  public static final int ARRAY_WRITE  = 3;

  // ===== Exceptions =====
  public static final int TRY_BLOCK       = 1;
  public static final int CATCH_BLOCK     = 2;
  public static final int THROW_EXCEPTION = 25;

  // ===== Synchronization =====
  public static final int SYNCHRONIZED_BLOCK = 20;

  // ===== Reflection =====
  public static final int REFLECTION_CALL = 50;

  // ===== I/O =====
  public static final int FILE_IO    = 100;
  public static final int NETWORK_IO = 200;

  private OperationWeights() {
    // No instantiation
  }
}
