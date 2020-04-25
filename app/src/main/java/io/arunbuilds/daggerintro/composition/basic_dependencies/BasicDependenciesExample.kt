package io.arunbuilds.daggerintro.composition.basic_dependencies

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Api

interface Dependencies {
    fun api(): Api
}

class Activity
@Module
class ActivityModule {
    @Provides
    fun providesActivity() = Activity()
}

class Tracker @Inject constructor(val activity: Activity, val api: Api)

@Component(modules = [ActivityModule::class], dependencies = [Dependencies::class])
interface ActivityComponent {
    // Will take the Api object from the Dependencies object to make the Tracker.
    fun giveMeATracker(): Tracker
}