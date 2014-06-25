package com.github.checketts.annotations

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

public class PendingExtension extends AbstractAnnotationDrivenExtension<Pending> {
    public void visitSpecAnnotation(Pending pending, SpecInfo spec) {

        for (FeatureInfo feature : spec.getFeatures())
            if (!feature.getFeatureMethod().getReflection().isAnnotationPresent(Pending.class))
                feature.getFeatureMethod().addInterceptor(new PendingInterceptor(pending,feature));
    }

    public void visitFeatureAnnotation(Pending pending, FeatureInfo feature) {
        feature.getFeatureMethod().addInterceptor(new PendingInterceptor(pending,feature));
    }
//
//    public void visitFixtureAnnotation(Pending pending, MethodInfo fixtureMethod) {
//        fixtureMethod.addInterceptor(new PendingInterceptor(pending));
//    }
}
