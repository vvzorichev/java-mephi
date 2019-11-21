javac -sourcepath src -d bin -classpath ./commons-codec-1.8.jar ./src/com/vvzorichev/Main.java ./src/com/vvzorichev/CountHash.java ./src/com/vvzorichev/InteractiveMode.java ./src/com/vvzorichev/SimpleMode.java
 
mkdir lib
cd lib
jar -xvf /home/Admin/web_mephi/lab1/commons-codec-1.8.jar org/
cd ..
cp -r bin/* lib/
jar -cef com.vvzorichev.Main lab1.jar -C lib .
rm -r lib
