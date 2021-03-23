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
    
    // https://mvnrepository.com/artifact/commons-io/commons-io
	implementation("commons-io:commons-io:2.8.0")
	
	// https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
	implementation("org.apache.commons:commons-lang3:3.12.0")
	
	implementation("com.password4j:password4j:1.5.2")
	
    
}
