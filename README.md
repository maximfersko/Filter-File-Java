# Filter-Data-Utils-Java

## Описание

Утилита предназначена для обработки файлов, содержащих различные типы данных (целые числа, вещественные числа, строки),
и записи их в соответствующие выходные файлы.

## Сборка и запуск утилиты

Сборка осуществляется с помощью Maven Wrapper

#### Unix:

```zsh
    ./mvnw clean compile package
```

#### Windows:

```zsh
    ./mvnw.cmd clean compile package
```

Пример запуска утилиты

```zsh
     java -jar target/util.jar -f -p prefix_ -o directory/data/ -a  in1.txt in2.txt
```

## Параметры командной строки

```zsh
    java -jar target/util.jar -f -p prefix_ -o directory/data/ -a  in1.txt in2.txt
```

Путь к файлам данных: несколько файлов, содержащих данные, передаются в командной строке и читаются в соответствии с
порядком их перечисления.

* Флаг -o: позволяет задать путь для сохранения результатов.
* Флаг -p: задает префикс имен выходных файлов.
* Флаг -a: включает режим добавления в существующие файлы.

### Статистика

В процессе фильтрации данных утилита собирает статистику по каждому типу данных. Статистика поддерживается в двух
вариантах:

* Краткая статистика (-s): содержит только количество элементов записанных в исходящие файлы.
* Полная статистика (-f): для чисел включает минимальное и максимальное значения, сумму и среднее. Для строк -
  количество, размер самой короткой и самой длинной строки.
  Статистика выводится в консоль.

## Зависимости

* Java 17
* Maven Wrapper 3.2.0
* Maven 3.9.5
* Lombok - https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.30
* JCommander - https://mvnrepository.com/artifact/com.beust/jcommander/1.81
* SLF4J API - https://mvnrepository.com/artifact/org.slf4j/slf4j-api/2.0.3
* SLF4J Simple Binding - https://mvnrepository.com/artifact/org.slf4j/slf4j-simple/2.0.3
* JUnit Jupiter - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.3
* JUnit Jupiter Params - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params/5.9.3

## Особенности реализации:

1. Написанный код следует принципам `SOLID`, что обеспечивает легкость расширения функциональности утилиты. При
   необходимости добавления новых возможностей или изменения существующих, код будет легко поддерживаем и модифицируем.

2. Утилита обеспечивает информативное сообщение об ошибке при передаче некорректного флага или в случае отсутствия
   входных файлов. После вывода сообщения об ошибке утилита также предоставляет полный список флагов и их описание.

3. Если передан неверный путь для сохранения результатов фильтрации данных, утилита сообщает об этой ошибке и не
   сохраняет результаты.

4. Утилита на вход принимает только файлы с расширением `.txt`, но при необходимости достаточно изменить паттерн
   расширений в классе `src/main/java/com/fersko/args/TxtFileConverter.java` перечеслив расширение через `|`

 ```java
  private static final String FILE_PATTERN = "glob:*.txt";
``` 
