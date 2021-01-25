# Упражнение на Git Bisect

В этом репозитории в какой-то момент (например, начиная с коммита c14c98573c5e89ce610094417fe450167ba914c2) появились хорошо работающие тесты.

Но потом кто-то коварно их испортил, и теперь необходимо найти коммит, который сломал тесты.

Для выполнения задания можно использовать как ручной перебор с использованием команд git bisect, так и автоматический.

Начнём с ручного:

1. Открыть этот проект в командной строке Git текущий проект.
2. Набрать в командной строке ```git bisect start``` - это будет инструкцией для Git начать процедуру поиска ошибки.
3. Набрать в командной строке ```git bisect bad``` - у нас ведь не работают тесты в текущем коммите, и вы хотите узнать причину.
4. Так как правильный коммит, начиная с которого должно работать - это c14c98573c5e89ce610094417fe450167ba914c2, пишем ```git bisect good c14c98573c5e89ce610094417fe450167ba914c2```, указывая нам на начало поисков.
5. Далее запускаем тесты и смотрим, проходят ли они. Если проходят - пишем ```git bisect good```, если падают - ```git bisect bad```.
6. После нескольких повторений Git укажет на коммит с сообщением о том, что именно он ломает тесты: "Small commit wich breaks my test" - так мы и в более сложных ситуациях можем понять, что же именно пошло не так.

Так как в этом проекте есть скрипт gradlew, который при запуске ```./gradlew test``` позволяет кодом завершения процесса сказать, успешно ли завершились тесты (0 если успешно, любой другой код обозначает наличие ошибок), то можно использовать команду git bisect run следующим образом:

```git bisect run ./gradlew test```

Далее git будет за нас отвечать good или bad, пока не покажет заветный коммит.

Спасибо за внимание!