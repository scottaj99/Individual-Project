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
java org.antlr.Tool JavaGrammar.g
```

5. Compile java files:
``` sh
javac *.java
```

6. Run translation tool:
``` sh
java Main Python.stg input
```
'input' in this instance should be directing the tool to where the file is that you want to translate, for example if you wanted to translate the forLoop from the test folder you would use the following:
``` sh
java Main Python.stg test/forLoop
```
