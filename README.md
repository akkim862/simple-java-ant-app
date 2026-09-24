# simple-java-ant-app

A minimal Java project built with **Apache Ant** (`build.xml`), meant as
an Ant equivalent of the well-known `jenkins-docs/simple-java-maven-app`
sample — for testing Jenkins freestyle jobs that use the **"Invoke Ant"**
build step.

## Project layout

```
simple-java-ant-app/
├── build.xml
├── README.md
└── src
    └── main
        └── java
            └── com
                └── example
                    └── App.java
```

## Build locally

Requires Ant and a JDK on your PATH.

```bash
ant clean      # remove build/ and dist/
ant compile    # compile sources into build/classes
ant jar        # package into dist/simple-java-ant-app.jar (default target)
ant run        # build then run the app
```

Expected output of `ant run`:

```
Hello Jenkins, built with Ant!
```

## Push to your own GitHub repo

```bash
cd simple-java-ant-app
git init
git add .
git commit -m "Initial commit: simple Ant project"
git branch -M main
git remote add origin https://github.com/<your-username>/simple-java-ant-app.git
git push -u origin main
```

## Jenkins freestyle job setup

1. **New Item** → Freestyle project.
2. **Source Code Management** → Git → paste your repo URL
   (`https://github.com/<your-username>/simple-java-ant-app.git`).
3. Leave **Advanced Project Options → Use custom workspace** unchecked
   (this avoids the malformed-path issue from before).
4. **Build** → **Add build step** → **Invoke Ant**.
5. Under **Advanced**, set **Build File** to `build.xml` (the default —
   only needed if it's not in the repo root).
6. **Targets**: `jar` (or leave blank to use the default target).
7. Save and **Build Now**.

If Ant isn't configured as a Jenkins tool yet: **Manage Jenkins →
Tools → Ant installations → Add Ant**, and either point it at an
existing local Ant install or let Jenkins auto-install a version.
