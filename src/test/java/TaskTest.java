import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;
import ru.netology.Task;

public class TaskTest {

    @Test
    public void shouldFindNoMatches() {
        Task task = new Task(5);

        boolean expected = false;
        boolean actual = task.matches("папа");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldOverrideSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldOverrideEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldOverrideMeetingMatchesIfProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldOverrideMeetingMatchesIfTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("кукареку");

        Assertions.assertEquals(expected, actual);
    }
}


