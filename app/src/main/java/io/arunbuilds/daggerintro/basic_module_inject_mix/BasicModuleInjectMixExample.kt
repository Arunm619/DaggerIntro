package io.arunbuilds.daggerintro.basic_module_inject_mix

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Wheel
class Car @Inject constructor(val wheels: Wheel)

@Module
class WheelsModule {
    @Provides
    fun providesWheels() = Wheel()
}

@Component(modules = [WheelsModule::class])
interface CarComponentMix {
    // While Car isn't registered through a Module, it has an inject constructor.
    // It requires a Wheels object, which will be gotten through WheelsModule.
    //
    // Note that since Wheels doesn't have an @Inject constructor,
    // it needs to be explicitly provided by a Module.
    fun getMeaCar(): Car
}