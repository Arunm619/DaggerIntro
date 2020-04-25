package io.arunbuilds.daggerintro.basic_module_inject

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Wheels @Inject constructor()
class Car @Inject constructor(val wheels: Wheels)

@Component
interface InjectCarComponent {
    //Objects with @Inject constructors can be created without explicit resolution.
    //This will just straight up give you a new Car(new Wheels())
    fun getMeaCar(): Car
}

@Module
class WheelsModule {
    @Provides
    fun providesWheel() = Wheels()
}

@Component(modules = [WheelsModule::class])
interface ModuleCarComponent {
    //However, if a provision is explicitly stated, that will be used instead.
    fun getMeACar(): Car
}