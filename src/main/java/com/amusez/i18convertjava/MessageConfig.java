package com.amusez.i18convertjava;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NotNull;

public class MessageConfig extends DynamicBundle {
    protected MessageConfig(@NotNull String pathToBundle) {
        super(pathToBundle);
    }
}
