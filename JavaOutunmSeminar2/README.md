# JavaOtumnSeminar2

##Task
- ID - уникальный идентификатор
- Summary - краткое описание задачи
- Priority - приоритет число от 0 до 10
- Status - { TODO, IN_PROGRESS, DONE, HOLD }
- DateCreated - дата создания
- DeadlineDate - дата deadline

## Operations
1. Создать задачу, ID должен присваиваться автоматически и дата создания тоже. На вход подаются значения полей задачи.
2. Получить задачу по id. Операция должна возвращать значения полей задачи по ID.
3. Удалить задачу. Операция должна удалять задачу из трекера.
4. Получить список всех задач. Операция возвращать список задач со всеми полями
5. Получить список задач на сегодня. Операция возвращает список задач, которых deadline сегодня.
6. Получить список задач отфильтрованных по статусу и отсортированных по приоритету.
7. Получить историю просмотра задач. Задачи должны идти по истории просмотра
8. Вывести задачки сгруппированными по статусам c сортировкой по приоритету
9. Получить задачку с наименьшим приоритетом.