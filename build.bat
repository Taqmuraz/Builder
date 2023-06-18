rd /s /q build
mkdir build
dir /s /b *.java > build/sourcelist.txt
javac -target 11 -source  11 -classpath lib/* -d build @build/sourcelist.txt
del build/sourcelist.txt
cd build
(echo Main-Class: Program & echo Class-Path: ../lib/a & echo. ) > manifest.txt
jar -cvfm build.jar manifest.txt .
cd ..