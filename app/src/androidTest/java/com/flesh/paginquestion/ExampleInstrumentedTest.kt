package com.flesh.paginquestion

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.flesh.paginquestion", appContext.packageName)
    }

    @Test
    fun testGettingPages(){
        val tools = (0..10)
        tools.forEach{
            val pages = DummyData().getPage(it)
            assertTrue(pages.size == 10)
        }
    }

}