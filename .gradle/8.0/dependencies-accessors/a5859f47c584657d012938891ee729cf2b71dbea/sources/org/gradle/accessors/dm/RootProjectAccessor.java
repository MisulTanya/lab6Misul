package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.internal.artifacts.dependencies.ProjectDependencyInternal;
import org.gradle.api.internal.artifacts.DefaultProjectDependencyFactory;
import org.gradle.api.internal.artifacts.dsl.dependencies.ProjectFinder;
import org.gradle.api.internal.catalog.DelegatingProjectDependency;
import org.gradle.api.internal.catalog.TypeSafeProjectDependencyFactory;
import javax.inject.Inject;

@NonNullApi
public class RootProjectAccessor extends TypeSafeProjectDependencyFactory {


    @Inject
    public RootProjectAccessor(DefaultProjectDependencyFactory factory, ProjectFinder finder) {
        super(factory, finder);
    }

    /**
     * Creates a project dependency on the project at path ":"
     */
    public MorozovaProjectDependency getMorozova() { return new MorozovaProjectDependency(getFactory(), create(":")); }

    /**
     * Creates a project dependency on the project at path ":feature"
     */
    public FeatureProjectDependency getFeature() { return new FeatureProjectDependency(getFactory(), create(":feature")); }

    /**
     * Creates a project dependency on the project at path ":impl"
     */
    public ImplProjectDependency getImpl() { return new ImplProjectDependency(getFactory(), create(":impl")); }

}
