| Classes    | Methods                                         | Scenario                                  | Outputs                                                 |
|------------|-------------------------------------------------|-------------------------------------------|---------------------------------------------------------|
| `TodoList` | `addTask(Task(String name, String description)` | If name and description are valid strings | none                                                    |
| `TodoList` | `getTasks()`                                    | If list has no entries                    | []                                                      |
|            |                                                 | If list has an entry                      | [Task]                                                  |
| `TodoList` | `getTasks(boolean uncompleteFilter)`            | If filter is true                         | All tasks marked as uncompleted                         |
|            |                                                 | If filter is false                        | All tasks marked as completed                           |
| `TodoList` | `changeCompleteStatus(String taskName)`         | If task 'taskName' was complete           | Returns task 'taskName' with completed now set as false |
|            |                                                 | If task 'taskName' was incomplete         | Returns task 'taskName' with completed now set as true  |
|            |                                                 | If there is no task named 'taskName'      | NoSuchElementException                                  |
| `TodoList` | `getTask(String taskName)`                      | If there is a task named 'taskName'       | Task@taskName                                           |
|            |                                                 | If there is no task named 'taskName'      | "There is no task by that name"                         |
| `TodoList` | `removeTask(String taskName)`                   | If there is a task named 'taskName'       | true                                                    |
|            |                                                 | If there is no task named 'taskName'      | NoSuchElementException                                  |
| `TodoList` | `getTasks(boolean ascending)`                   | ascending is false                        | A list of tasks, sorted alphabetically a-z              |
|            |                                                 | ascending is true                         | A list of tasks, sorted alphabetically z-a              |
