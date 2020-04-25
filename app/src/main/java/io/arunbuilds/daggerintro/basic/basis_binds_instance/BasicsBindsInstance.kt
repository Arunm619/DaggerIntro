package io.arunbuilds.daggerintro.basic.basis_binds_instance

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides

open class Wheels
class FireWheels : Wheels()

@Module
class FireWheelsModule {
    @Provides
    fun providesFireWheels(): FireWheels = FireWheels()
}

/*
@Module
class WheelsModule {
    @Provides
    fun providesWheels(fireWheels: FireWheels) = fireWheels as Wheels
}
*/

@Module
abstract class WheelsModule {
    /**
     * Equivalent to
     * @Provides
     * fun provideWheels(fire: FireWheels) = fire as Wheels
     */
    @Binds
    abstract fun castThoseWheels(fire: FireWheels): Wheels
}

@Component(modules = [WheelsModule::class, FireWheelsModule::class])
interface Component {
    fun giveMeSomeWheels(): Wheels
}