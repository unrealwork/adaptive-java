package org.stepik.jetbrains.adaptive.java.collections;

import java.util.List;
import java.util.function.IntPredicate;

public class PredicateComposing {

  /**
   * The method represents a disjunct operator for a list of predicates.
   * For an empty list it returns the always false predicate.
   */
  public static IntPredicate disjunctAll(List<IntPredicate> predicates) {

    return predicates.stream().reduce((n) -> false, IntPredicate::or);
  }
}
