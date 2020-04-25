package io.arunbuilds.daggerintro.composition.basic_subcomponent

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject

class Api

@Module
class ApiModule {
    @Provides
    fun providesApi() =
        Api()
}

class Activity

@Module
class ActivityModule {
    @Provides
    fun providesActivity() =
        Activity()
}

class Tracker @Inject constructor(val activity: Activity, val api: Api)

@Subcomponent(modules = [ActivityModule::class])
interface ActivitySubComponent {
    fun giveMeATracker(): Tracker

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivitySubComponent
    }
}

@Module(subcomponents = [ActivitySubComponent::class])
class SubComponentModule

@Component(modules = [ApiModule::class, SubComponentModule::class])
interface ApplicationComponent {
    fun activitySubcomponentFactory(): ActivitySubComponent.Factory
}