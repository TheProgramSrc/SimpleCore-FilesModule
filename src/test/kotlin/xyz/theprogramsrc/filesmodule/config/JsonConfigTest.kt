package xyz.theprogramsrc.filesmodule.config

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File

internal class JsonConfigTest {

    companion object {
        private val config = JsonConfig(File("test.json"))

        @BeforeAll
        fun setUp() {
            config.destroy()
            config.load()
        }

        @AfterAll
        fun tearDown() {
            config.destroy()
        }

    }

    @Test
    fun has() {
        assertFalse(config.has("test"))
        config.set("test", "test")
        assertTrue(config.has("test"))
        config.remove("test")
    }

    @Test
    fun set() {
        config.set("test", "test")
        assertEquals("test", config.getString("test"))
        config.set("test", "test2")
        assertEquals("test2", config.getString("test"))
        config.remove("test")
    }

    @Test
    fun add() {
        config.add("test", "test")
        config.add("test", "test2")
        assertEquals("test", config.getString("test"))
        config.remove("test")
    }

    @Test
    fun increase(){
        config.increase("increase")
        assertEquals(0, config.getInt("increase"))
        config.increase("increase")
        assertEquals(1, config.getInt("increase"))
        config.increase("increase")
        assertEquals(2, config.getInt("increase"))
        config.remove("increase")
    }

    @Test
    fun decrease(){
        config.decrease("decrease")
        assertEquals(0, config.getInt("decrease"))
        config.decrease("decrease")
        assertEquals(-1, config.getInt("decrease"))
        config.decrease("decrease")
        assertEquals(-2, config.getInt("decrease"))
        config.remove("decrease")
    }

    @Test
    fun addNumber(){
        config.add("addNumber", 1 as Number)
        assertEquals(1 as Number, config.getNumber("addNumber"))
        config.add("addNumber", 2 as Number)
        assertEquals(1 as Number, config.getNumber("addNumber"))
        config.set("addNumber", 3 as Number)
        assertEquals(3 as Number, config.getNumber("addNumber"))
        config.remove("addNumber")
    }
}