package com.github.checketts.annotations

import org.spockframework.runtime.SpockAssertionError
import org.spockframework.util.Nullable

/**
 * Created by clintchecketts on 6/23/14.
 */
public class PendingError extends SpockAssertionError {
    private final Class<? extends Throwable> expected;
    private final String explanation;

    public PendingError(@Nullable String explanation) {
        super(explanation);
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    @Override
    public String getMessage() {
        if (explanation == null || explanation.length() == 0) {
            return String.format("Expected pending feature to fail, but succeeded instead",explanation);
        }
        return String.format("Expected pending feature to fail, but succeeded instead. Pending reason: %s",explanation);
    }
}