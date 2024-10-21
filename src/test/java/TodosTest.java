
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTask() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTask() {
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEpic() {
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");

        Assertions.assertArrayEquals(expected, actual);
    }
}

