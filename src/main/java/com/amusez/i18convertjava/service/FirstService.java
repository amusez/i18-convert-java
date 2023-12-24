//package com.amusez.i18convertjava.service;
//
//import com.intellij.diagnostic.ActivityCategory;
//import com.intellij.openapi.components.Service;
//import com.intellij.openapi.diagnostic.Logger;
//import com.intellij.openapi.extensions.ExtensionsArea;
//import com.intellij.openapi.extensions.PluginDescriptor;
//import com.intellij.openapi.extensions.PluginId;
//import com.intellij.openapi.project.Project;
//import com.intellij.openapi.util.Condition;
//import com.intellij.openapi.util.Key;
//import com.intellij.openapi.util.NlsSafe;
//import com.intellij.openapi.vfs.VirtualFile;
//import com.intellij.util.messages.MessageBus;
//import kotlinx.coroutines.CoroutineScope;
//import org.jetbrains.annotations.NonNls;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import org.jetbrains.annotations.SystemIndependent;
//import org.picocontainer.PicoContainer;
//
//import java.util.Map;
//
//@Service(Service.Level.PROJECT)
//public final class FirstService implements Project {
//    private final Logger logger = Logger.getInstance(FirstService.class);
//    {
//        logger.info(this.getName());
//        logger.warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");
//    }
//
//    @Override
//    public @NotNull @NlsSafe String getName() {
//        return this.getClass().getName();
//    }
//
//    @Override
//    public VirtualFile getBaseDir() {
//        return null;
//    }
//
//    @Override
//    public @Nullable @SystemIndependent @NonNls String getBasePath() {
//        return null;
//    }
//
//    @Override
//    public @Nullable VirtualFile getProjectFile() {
//        return null;
//    }
//
//    @Override
//    public @Nullable @SystemIndependent @NonNls String getProjectFilePath() {
//        return null;
//    }
//
//    @Override
//    public @Nullable VirtualFile getWorkspaceFile() {
//        return null;
//    }
//
//    @Override
//    public @NotNull @NonNls String getLocationHash() {
//        return null;
//    }
//
//    @Override
//    public void save() {
//
//    }
//
//    @Override
//    public boolean isOpen() {
//        return false;
//    }
//
//    @Override
//    public boolean isInitialized() {
//        return false;
//    }
//
//    @Override
//    public CoroutineScope getCoroutineScope() {
//        return null;
//    }
//
//    @Override
//    public <T> T getComponent(@NotNull Class<T> aClass) {
//        return null;
//    }
//
//    @Override
//    public boolean hasComponent(@NotNull Class<?> aClass) {
//        return false;
//    }
//
//    @Override
//    public @NotNull PicoContainer getPicoContainer() {
//        return null;
//    }
//
//    @Override
//    public boolean isInjectionForExtensionSupported() {
//        return false;
//    }
//
//    @Override
//    public @NotNull MessageBus getMessageBus() {
//        return null;
//    }
//
//    @Override
//    public boolean isDisposed() {
//        return false;
//    }
//
//    @Override
//    public @NotNull Condition<?> getDisposed() {
//        return null;
//    }
//
//    @Override
//    public <T> T getService(@NotNull Class<T> aClass) {
//        return null;
//    }
//
//    @Override
//    public @NotNull ExtensionsArea getExtensionArea() {
//        return null;
//    }
//
//    @Override
//    public <T> T instantiateClassWithConstructorInjection(@NotNull Class<T> aClass, @NotNull Object o, @NotNull PluginId pluginId) {
//        return null;
//    }
//
//    @Override
//    public @NotNull RuntimeException createError(@NotNull Throwable throwable, @NotNull PluginId pluginId) {
//        return null;
//    }
//
//    @Override
//    public @NotNull RuntimeException createError(@NotNull @NonNls String s, @NotNull PluginId pluginId) {
//        return null;
//    }
//
//    @Override
//    public @NotNull RuntimeException createError(@NotNull @NonNls String s, @Nullable Throwable throwable, @NotNull PluginId pluginId, @Nullable Map<String, String> map) {
//        return null;
//    }
//
//    @Override
//    public @NotNull <T> Class<T> loadClass(@NotNull String s, @NotNull PluginDescriptor pluginDescriptor) throws ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public <T> @NotNull T instantiateClass(@NotNull String s, @NotNull PluginDescriptor pluginDescriptor) {
//        return null;
//    }
//
//    @Override
//    public @NotNull ActivityCategory getActivityCategory(boolean b) {
//        return null;
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//
//    @Override
//    public <T> @Nullable T getUserData(@NotNull Key<T> key) {
//        return null;
//    }
//
//    @Override
//    public <T> void putUserData(@NotNull Key<T> key, @Nullable T t) {
//
//    }
//}
