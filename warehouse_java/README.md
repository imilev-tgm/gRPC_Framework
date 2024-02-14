# gRPC in Springboot Java
Author: Rahul Gupta
Date: Feb, 14
## Explanation of the Project
### Getting started
In order to utilize gRPC with Springboot we need to use gradle and define the necassary code blocks inside the **build.gradle** file. With spring initializr[0] you can initialize a basic spring boot project. Project --> Gradle - Groovy, Language --> Java, Spring Boot --> 3.2.2, Packaging --> Jar, Java --> 17. 
After that I have searched the web for the necessary dependencies and plugins. This is how the working **build.gradle** looked in the end.

```gradle
plugins {  
    id 'java'  
    id 'org.springframework.boot' version '3.2.2'  
    id 'io.spring.dependency-management' version '1.1.4'  
    id "com.google.protobuf" version "0.9.4" // the plugin for protobuf
}  
  
group = 'com.example'  
version = '0.0.1-SNAPSHOT'  
  
java {  
    sourceCompatibility = '17'  
}  
  
repositories {  
    mavenCentral()   // the repository it searches for the dependencies
}  
  
dependencies {  
    // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java  
    implementation group: 'com.google.protobuf', name: 'protobuf-java', version: '3.25.2'  
    implementation 'org.springframework.boot:spring-boot-starter'  
    testImplementation 'org.springframework.boot:spring-boot-starter-test'  
    runtimeOnly 'io.grpc:grpc-netty-shaded:1.61.0'  // grpc-dependency
    implementation 'io.grpc:grpc-protobuf:1.61.0'  // grpc-dependency
    implementation 'io.grpc:grpc-stub:1.61.0'   // grpc-dependency
    compileOnly 'org.apache.tomcat:annotations-api:6.0.53' // necessary for Java 9+  
}  
  
tasks.named('test') {  
    useJUnitPlatform()  
}  
  
protobuf {  
    generateProtoTasks {  
       { task ->  
          task.plugins {  
             grpc {  
                // Use subdirectory 'grpcjava' instead of the default 'grpc'  
                outputSubDir = 'grpcjava'  
             }  
          }       }    }}  
  
sourceSets {  
    main {  
       java {  
			// set the following to directories as src directories 
			// this is done so the generated java files out of the .proto
			// can be imported
          srcDirs 'build/generated/source/proto/main/java', 'src/main/java'  
       }  
    }}
```

### Generating Java files out of .proto file 
`./gradlew generateProto`
### Common Issues and Solutions

1. **Importing the Generated Class Issue**: The generated `PersonOuterClass` couldn't be imported. This was resolved by adjusting the `sourceSets` in `build.gradle` to include the directory of the generated sources, so the IDE could recognize them as part of the project. In the `build.gradle` file, it was:

```gradle
sourceSets {  
    main {  
       java {  
          srcDirs 'build/generated/source/proto/main/java', 'src/main/java'  
       }  
    }
}
```

With this, `PersonOuterClass` could be imported with: `import com.example.proto.PersonOuterClass;`

2. **`generateProto` Execution Error**: Attempting to run the `generateProto` task failed due to an unresolved dependency. This was caused by using a release candidate version (`4.26.0-RC2`) of `protobuf-java`, which might have been incompatible or not available. The solution was to switch to a stable version, which was **3.25.2** in this case, and restarting the IDE resolved the issue. It also turned out that the mavenCentral repository is not always up to date with the latest releases of plugins and dependencies. 

3. **Missing Package Declaration**: Initially, the generated class couldn't be imported because the `.proto` file lacked a package declaration, causing the generated class to default to the default package. The issue was fixed by adding a `package` statement to the `.proto` file and re-running the `generateProto` task to regenerate the classes with the correct package name. For this case, it was **package com.example.proto;**

```proto
syntax = "proto3";
  
package com.example.proto; 
  
message Person {  
  optional string name = 1;  
  optional int64 id = 2;  
  optional string email = 3;
}
```

[0]: https://start.spring.io

