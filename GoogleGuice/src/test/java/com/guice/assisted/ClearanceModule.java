/**
 * 
 */
package com.guice.assisted;

import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class ClearanceModule extends com.google.inject.AbstractModule{

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(Clearable.class,ClearanceProber.class)
                .build(ClearanceProber.ClearaceProberFactory.class));
    }
}