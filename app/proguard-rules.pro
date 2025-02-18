#
## AOP
#-adaptclassstrings
#-keepattributes InnerClasses, EnclosingMethod, Signature, *Annotation*
#
#
## Gson specific classes
#-dontwarn sun.misc.**
##-keep class com.google.gson.stream.** { *; }
#
## OSS_ANDROID_TEMPLATE_FILE_HEADER
##
## Proguard config for publish an private aar module
## NOTE: It's different from libraries' consumer proguard config
##
#-renamesourcefileattribute SourceFile
#-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,EnclosingMethod
#
## Preserve all annotations.
#
#-keepattributes *Annotation*
#
## Preserve all public classes, and their public and protected fields and
## methods.
#
#-keep public class * {
#    public protected *;
#}
#
## Preserve all .class method names.
#
#-keepclassmembernames class * {
#    java.lang.Class class$(java.lang.String);
#    java.lang.Class class$(java.lang.String, boolean);
#}
#
## Preserve all native method names and the names of their classes.
#
#-keepclasseswithmembernames class * {
#    native <methods>;
#}
#
## Preserve the special static methods that are required in all enumeration
## classes.
#
#-keepclassmembers class * extends java.lang.Enum {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}
#
## Explicitly preserve all serialization members. The Serializable interface
## is only a marker interface, so it wouldn't save them.
## You can comment this out if your library doesn't use serialization.
## If your code contains serializable classes that have to be backward
## compatible, please refer to the manual.
#
#-keepclassmembers class * implements java.io.Serializable {
#    static final long serialVersionUID;
#    static final java.io.ObjectStreamField[] serialPersistentFields;
#    private void writeObject(java.io.ObjectOutputStream);
#    private void readObject(java.io.ObjectInputStream);
#    java.lang.Object writeReplace();
#    java.lang.Object readResolve();
#}
#
#-dontnote junit.**
#-dontnote org.xmlpull.v1.**
#-dontwarn junit.**
#-dontwarn org.junit.**
#-dontwarn android.content.**
#
#-dontwarn com.squareup.okhttp.CipherSuite
#-dontwarn com.squareup.okhttp.ConnectionSpec
#-dontwarn com.squareup.okhttp.TlsVersion
#
#-keep class org.xmlpull.v1.** { *; }
##-keep class vn.xdeuhug.music.data.model.** { *; }
#-keepclassmembers class * {
#    <init>(...);
#}
#
#
#-keep class com.shockwave.**
#
#-keep class android.support.v8.renderscript.** { *; }
#-keep class androidx.renderscript.** { *; }
#-keepattributes *Annotation*
## Gson specific classes
#-dontwarn sun.misc.**
#
## Application classes that will be serialized/deserialized over Gson
#-keep class com.google.gson.examples.android.model.** { <fields>; }
#
# -keep class com.gyf.immersionbar.* {*;}
# -dontwarn com.gyf.immersionbar.**
# -keep class com.airbnb.lottie.samples.** { *; }
# -keep class com.wang.avi.** { *; }
# -keep class com.wang.avi.indicators.** { *; }
#-dontwarn org.jetbrains.annotations.**
#
#-dontnote junit.**
#-dontnote org.xmlpull.v1.**
#-dontwarn junit.**
#-dontwarn org.junit.**
#-dontwarn android.content.**
#
## Most of volatile fields are updated with AFU and should not be mangled
#-keepclassmembers class kotlinx.coroutines.** {
#    volatile <fields>;
#}
#
#-optimizationpasses 5
#-dontskipnonpubliclibraryclasses
#-dontskipnonpubliclibraryclassmembers
#-dontpreverify
#-verbose
#-optimizations !code/simplification/cast,!field/*,!class/merging/*
#-keepattributes *Annotation*,InnerClasses
#-keepattributes Signature
#-keepattributes SourceFile,LineNumberTable
#-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,EnclosingMethod
#
## OkHttp platform used only on JVM and when Conscrypt and other security providers are available.
#-dontwarn okhttp3.internal.platform.**
#-dontwarn org.conscrypt.**
#-dontwarn org.bouncycastle.**
#-dontwarn org.openjsse.**
#
## JSR 305 annotations are for embedding nullability information.
#-dontwarn javax.annotation.**
#
## A resource is loaded with a relative path so the package of this class must be preserved.
#-adaptresourcefilenames okhttp3/internal/publicsuffix/PublicSuffixDatabase.gz
#
## Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
#-dontwarn org.codehaus.mojo.animal_sniffer.*
#
## Dexter
#-keepattributes InnerClasses, Signature, *Annotation*
#-keep class com.karumi.dexter.** { *; }
#-keep interface com.karumi.dexter.** { *; }
#-keepclasseswithmembernames class com.karumi.dexter.** { *; }
#-keepclasseswithmembernames interface com.karumi.dexter.** { *; }
#
## lottie-android
#-keep class com.airbnb.lottie.samples.** { *; }
#
##aliyunplayer
#-keep class com.alivc.**{*;}
#-keep class com.aliyun.**{*;}
#-keep class com.cicada.**{*;}
#-dontwarn com.alivc.**
#-dontwarn com.aliyun.**
#-dontwarn com.cicada.**
#
## optimize
#-optimizationpasses 2
#-optimizations !code/simplification/arithmetic
#-dontusemixedcaseclassnames
#-dontskipnonpubliclibraryclasses
#
### Please add these rules to your existing keep rules in order to suppress warnings.
### This is generated automatically by the Android Gradle plugin.
#-dontwarn androidx.lifecycle.ViewModelKt
#-dontwarn coil.request.LoadRequest$Companion
#-dontwarn coil.request.LoadRequest
#-dontwarn coil.request.LoadRequestBuilder
#-dontwarn coil.request.RequestBuilder
#-dontwarn coil.request.RequestDisposable
#
### Dragger hilt
#-keep class * extends androidx.lifecycle.ViewModel { *; }
#-keep class * extends dagger.hilt.** { *; }
#-keepattributes *Annotation*
#
#-keep class vn.xdeuhug.base.presentation.ui.viewmodel.MainViewModel { *; }
