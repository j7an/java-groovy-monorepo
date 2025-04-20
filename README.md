# Java and Groovy Monorepo Example

This repository demonstrates a basic monorepo structure using Gradle, containing both Java and Groovy subprojects (`core`, `restassured-java`, `restassured-groovy`).

## Project Structure

*   `core/`: A shared Java library module.
*   `restassured-java/`: A Java module using REST Assured for testing, depending on `core`.
*   `restassured-groovy/`: A Groovy module using Spock and REST Assured for testing, depending on `core`.
*   `build.gradle.kts`: Root project build configuration (Kotlin DSL).
*   `settings.gradle.kts`: Defines the included subprojects (Kotlin DSL).
*   `gradlew`/`gradlew.bat`: Gradle wrapper scripts.

## Setting up a similar project

You can initialize a similar basic Gradle project structure using the `gradle init` command. To create a project with Kotlin DSL build scripts, follow these steps:

1.  **Navigate to an empty directory** in your terminal.
2.  **Run the Gradle init task:**

    ```sh
    gradle init --type basic --dsl kotlin
    ```

    *   `--type basic`: Creates a minimal project structure without sample code, just the necessary Gradle files (`build.gradle.kts`, `settings.gradle.kts`, wrapper files).
    *   `--dsl kotlin`: Specifies that the build scripts should use the Kotlin DSL instead of the default Groovy DSL.

3.  **Define subprojects:** Edit the generated `settings.gradle.kts` file to include your desired subprojects (modules), similar to the [`settings.gradle.kts`](settings.gradle.kts) in this repository.

    ```kotlin
    // filepath: settings.gradle.kts
    rootProject.name = "your-monorepo-name"

    include("core")
    include("feature-java")
    include("feature-groovy")
    // Add other modules as needed
    ```

4.  **Create subproject directories:** Create the corresponding directories for each included subproject (e.g., `core/`, `feature-java/`, `feature-groovy/`).
5.  **Add build files to subprojects:** Create a `build.gradle.kts` file within each subproject directory to define its specific plugins, dependencies, and configurations (see [`core/build.gradle.kts`](core/build.gradle.kts), [`restassured-java/build.gradle.kts`](restassured-java/build.gradle.kts), [`restassured-groovy/build.gradle.kts`](restassured-groovy/build.gradle.kts) for examples).
6.  **Configure root build file:** Add common configurations (like repositories, plugin versions, cross-project settings) to the root [`build.gradle.kts`](build.gradle.kts).

## Building the Project

To build all subprojects, run:

```sh
./gradlew build