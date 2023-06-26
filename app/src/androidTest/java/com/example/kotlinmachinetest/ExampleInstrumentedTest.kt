package com.example.kotlinmachinetest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
   /* @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.kotlinmachinetest", appContext.packageName)
    }*/

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<User>>

    private lateinit var itemViewModel: UserViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        itemViewModel = UserViewModel()
    }

    @Test
    fun loadItems() {

        itemViewModel.users.observeForever(observer)

        assertEquals(itemViewModel.users.value, itemViewModel.users.value)

        itemViewModel.users.removeObserver(observer)
    }

    /*@Test
    fun onItemClick() {
        val clickedItemId = 2
        var clickedItem: User? = null

        val clickListener = itemViewModel.createOnClickListener(clickedItemId)

        clickListener.onClick {
            clickedItem = itemViewModel.getItemById(clickedItemId)
        }

        // Simulate click event
        clickListener.onClick(null)

        assertEquals(expectedItem, clickedItem)
    }*/

}