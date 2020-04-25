package io.arunbuilds.daggerintro.basic.basic_module_dependency

import dagger.Component
import dagger.Module
import dagger.Provides

class Wheel
class Car(val wheel: Wheel)

@Module
class WheelModule {
    @Provides
    fun providesWheel() = Wheel()
}

@Module
class WheeledCarModule {
    //Note that wheels is not provided explicitly inside the WheeledCarModule
    //It's resolved at ComponentLevel.
    @Provides
    fun providesWheeledCar(wheel: Wheel) = Car(wheel)
}

@Component(modules = [WheelModule::class, WheeledCarModule::class])
interface WheeledCarComponent {
    //since we provided WheelsModule, it'll query WheelModule.providesWheel()
    //for wheels, and pass it to WheeledCarModule.providesWheeledCar(wheel).
    fun getMeACar(): Car
}