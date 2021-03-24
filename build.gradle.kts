plugins {
	java
	application 
	id("org.openjfx.javafxplugin") version "0.0.9"
}

repositories {
	mavenCentral()
}

javafx {
	version = "15"
    modules("javafx.controls", "javafx.fxml")
}

application.mainClassName = "iuniversity.Launcher"

dependencies {
	//implementation("com.calendarfx:view:11.8.3")
	//implementation ("org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0")
	//testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    //testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testRuntime("org.junit.platform:junit-platform-runner:1.5.2")
}
