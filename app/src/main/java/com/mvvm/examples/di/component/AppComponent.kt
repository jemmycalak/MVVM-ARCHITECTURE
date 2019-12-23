package com.mvvm.examples.di.component

import com.mvvm.examples.di.builder.ActivityBuilder
import com.mvvm.examples.di.module.AppModule
import com.mvvm.examples.ui.base.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {
    fun inject(app:App)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(app:App):Builder
        fun build():AppComponent
    }
}