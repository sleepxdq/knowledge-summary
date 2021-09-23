plugins {
    java
}
group = "com.xdq.base"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies{
    // https://mvnrepository.com/artifact/cglib/cglib
    implementation("cglib:cglib:3.3.0")
}