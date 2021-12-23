package xyz.theprogramsrc.filesmodule.config

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File

internal class YmlConfigTest {

    companion object {
        private val config = YmlConfig(File("test.yml"))

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
    fun hasAndSet() {
        assertFalse(config.has("test"))
        config.set("test", "test")
        assertTrue(config.has("test"))
        assertEquals("test", config.get("test"))
        config.remove("test")
    }

    @Test
    fun addAndGet() {
        assertFalse(config.has("test"))
        config.add("test", "test")
        assertTrue(config.has("test"))
        assertEquals("test", config.get("test"))
        config.add("test", "test2")
        assertEquals("test", config.get("test"))
        config.remove("test")
    }

    @Test
    fun getInt() {
        assertFalse(config.has("test"))
        config.set("test", 1)
        assertTrue(config.has("test"))
        assertEquals(1, config.getInt("test"))
        assertTrue(config.get("test") is Int)
        config.remove("test")
    }

    @Test
    fun getBoolean() {
        assertFalse(config.has("test"))
        config.set("test", true)
        assertTrue(config.has("test"))
        assertTrue(config.getBoolean("test"))
        assertTrue(config.get("test") is Boolean)
        config.remove("test")
    }

    @Test
    fun getOrSetString(){
        assertFalse(config.has("test"))
        assertEquals("test", config.getOrSet("test", "test"))
        assertTrue(config.has("test"))
        config.remove("test")
    }
}