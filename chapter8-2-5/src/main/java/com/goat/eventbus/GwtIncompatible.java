

package com.goat.eventbus;

import java.lang.annotation.*;

/**
 * The presence of this annotation on an API indicates that the method may <em>not</em> be used with
 * the <a href="http://www.gwtproject.org/">Google Web Toolkit</a> (GWT).
 *
 * <p>This annotation behaves identically to <a href=
 * "http://www.gwtproject.org/javadoc/latest/com/google/gwt/core/shared/GwtIncompatible.html">the
 * {@code @GwtIncompatible} annotation in GWT itself</a>.
 *
 * @author Charles Fry
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Documented
@GwtCompatible
public @interface GwtIncompatible {
  /**
   * Describes why the annotated element is incompatible with GWT. Since this is generally due to a
   * dependence on a type/method which GWT doesn't support, it is sufficient to simply reference the
   * unsupported type/method. E.g. "Class.isInstance".
   *
   * <p>As of Guava 20.0, this value is optional. We encourage authors who wish to describe why an
   * API is {@code @GwtIncompatible} to instead leave an implementation comment.
   */
  String value() default "";
}
