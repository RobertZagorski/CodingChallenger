object Versions {
    const val AndroidXCoreVersion = "1.7.0"
    const val AndroidAppCompatVersion = "1.4.0"
    const val KotlinVersion = "1.5.32"
    const val NavigationVersion = "2.3.4"
    const val MaterialComponentsVersion = "1.4.0"

    const val JUnitVersion = "4.13.2"
    const val MockitoVersion = "4.1.0"
    const val MockitoKotlinVersion = "4.0.0"
    const val AndroidXTestVersion = "1.4.0"
    const val EspressoVersion = "3.4.0"
    const val HiltVersion = "2.38.1"
    const val RetrofitVersion = "2.9.0"
    const val RxJava3 = "3.1.3"
}

object Artifacts {
    const val AndroidX = "androidx.core:core"
    const val AppCompat = "androidx.appcompat:appcompat"
    const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val NavigationFragment = "androidx.navigation:navigation-fragment-ktx"
    const val NavigationUi = "androidx.navigation:navigation-ui-ktx"
    const val MaterialComponents = "com.google.android.material:material"

    const val JUnit = "junit:junit"
    const val Mockito = "org.mockito:mockito-core"
    const val MockitoKotlin = "org.mockito.kotlin:mockito-kotlin"
    const val AndroidXTest = "androidx.test:core"
    const val Espresso = "androidx.test.espresso:espresso-core"

    const val HiltAndroid = "com.google.dagger:hilt-android"
    const val HiltCompiler = "com.google.dagger:hilt-compiler"

    const val RxJava3 = "io.reactivex.rxjava3:rxjava"

    const val Retrofit = "com.squareup.retrofit2:retrofit"
    const val Rxjava3Retrofit2CallAdapter = "com.squareup.retrofit2:adapter-rxjava3"
    const val GsonConverter = "com.squareup.retrofit2:converter-gson"
}

object Dependencies {
    const val AndroidX = "${Artifacts.AndroidX}:${Versions.AndroidXCoreVersion}"
    const val AppCompat = "${Artifacts.AppCompat}:${Versions.AndroidAppCompatVersion}"
    const val HiltAndroid = "${Artifacts.HiltAndroid}:${Versions.HiltVersion}"
    const val HiltCompiler = "${Artifacts.HiltCompiler}:${Versions.HiltVersion}"
    const val Kotlin = "${Artifacts.Kotlin}:${Versions.KotlinVersion}"
    const val NavigationFragment = "${Artifacts.NavigationFragment}:${Versions.NavigationVersion}"
    const val NavigationUi = "${Artifacts.NavigationUi}:${Versions.NavigationVersion}"
    const val MaterialComponents = "${Artifacts.MaterialComponents}:${Versions.MaterialComponentsVersion}"
    const val Retrofit = "${Artifacts.Retrofit}:${Versions.RetrofitVersion}"
    const val RxJava3 = "${Artifacts.RxJava3}:${Versions.RxJava3}"
    const val RxJava3Retrofit2CallAdapter = "${Artifacts.Rxjava3Retrofit2CallAdapter}:${Versions.RetrofitVersion}"
    const val GsonConverter = "${Artifacts.GsonConverter}:${Versions.RetrofitVersion}"
}

object TestDependencies {
    const val JUnit = "${Artifacts.JUnit}:${Versions.JUnitVersion}"
    const val Mockito = "${Artifacts.Mockito}:${Versions.MockitoVersion}"
    const val MockitoKotlin = "${Artifacts.MockitoKotlin}:${Versions.MockitoKotlinVersion}"
    const val AndroidXTest = "${Artifacts.AndroidXTest}:${Versions.AndroidXTestVersion}"
    const val Espresso = "${Artifacts.Espresso}:${Versions.EspressoVersion}"
}
