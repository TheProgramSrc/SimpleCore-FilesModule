package xyz.theprogramsrc.filesmodule.config

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File

internal class PropertiesConfigTest {

    companion object {
        private val config = PropertiesConfig(File("test.properties"))

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
        config.set("test2", "test")
        assertTrue(config.has("test2"))
        config.remove("test2")
    }

    @Test
    fun getAndSet() {
        assertNull(config.get("test"))
        config.set("test2", "test")
        assertEquals("test", config.get("test2"))
        config.remove("test2")
    }

    @Test
    fun add() {
        config.add("test", "test")
        assertEquals("test", config.get("test"))
        config.add("test", "test2")
        assertEquals("test", config.get("test"))
        config.remove("test")
    }

    @Test
    fun remove() {
        config.add("test", "test")
        config.remove("test")
        assertNull(config.get("test"))
        assertFalse(config.has("test"))
    }
}