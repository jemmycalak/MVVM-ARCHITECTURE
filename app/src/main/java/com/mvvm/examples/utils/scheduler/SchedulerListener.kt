package com.mvvm.examples.utils.scheduler

import io.reactivex.Scheduler

interface SchedulerListener {
    fun computation():Scheduler
    fun io():Scheduler
    fun ui():Scheduler
}