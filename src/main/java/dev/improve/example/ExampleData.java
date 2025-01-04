package dev.improve.example;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.UUID;

public class ExampleData implements Serializable {

    private final UUID uuid;
    private final String name;
    public boolean isBlacklisted;

    public ExampleData(@NotNull final UUID uuid, @NotNull final String name) {
        this.uuid = uuid;
        this.name = name;
    }


    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public boolean isBlacklisted() {
        return isBlacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        isBlacklisted = blacklisted;
    }
}
