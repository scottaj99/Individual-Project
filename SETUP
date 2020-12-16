1. Once file has been pulled, activate virtual environment:
``` sh
venv\Scripts\activate
```

2. Add antlr-3.5.2-complete.jar to CLASSPATH
(on windows):
``` sh
SET CLASSPATH=.;..\usr\local\lib\Inidividual-Project\antlr-3.5.2-complete.jar;%CLASSPATH%
```

3. Enter the translator folder
``` sh
cd translator
```

4. generate helper java files:
``` sh
java org.antlr.Tool Java.g
```

5. Compile java files:
``` sh
javac *.java
```

6. Run translation tool:
``` sh
java Main Python.stg input
```

7. Change the java code in the file titled 'input' to change the code that is being produced. 
