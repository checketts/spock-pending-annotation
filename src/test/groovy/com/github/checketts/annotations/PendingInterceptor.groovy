package com.github.checketts.annotations

import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo

/**
 * Created by clintchecketts on 6/23/14.
 */
public class PendingInterceptor  implements IMethodInterceptor {
    private final Pending pending;
    private final FeatureInfo feature;

    public PendingInterceptor(Pending pending, FeatureInfo feature) {
        this.pending = pending;
        this.feature = feature;
    }

    public void intercept(IMethodInvocation invocation) throws Throwable {
        try {
            feature.setSkipped(true)
            invocation.proceed();
        } catch (Throwable t) {
            //An error is allowed since the test is pending. Flag it as a skipped test for reporting though
            //throw new PendingError("Feature is pending: $feature.name")
            return
        }

        throw new NotPendingError(pending.value());
    }
}