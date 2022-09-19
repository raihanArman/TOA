package com.randev.toa

import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * @author Raihan Arman
 * @date 15/09/22
 */
class ThreadExceptionHandlerTestRule : TestWatcher() {

    private var previousHandler: Thread.UncaughtExceptionHandler ? = null

    override fun starting(description: Description) {
        super.starting(description)

        previousHandler = Thread.getDefaultUncaughtExceptionHandler()

        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            throw throwable
        }
    }

    override fun finished(description: Description) {
        super.finished(description)
        Thread.setDefaultUncaughtExceptionHandler(previousHandler)
    }
}
