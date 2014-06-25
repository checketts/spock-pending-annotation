package com.github.checketts.annotations

import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.METHOD])
@ExtensionAnnotation(PendingExtension)
public @interface Pending {
    /**
     * The explanation behind the pending feature.
     *
     * @return the explanation
     */
    String value() default "";
}